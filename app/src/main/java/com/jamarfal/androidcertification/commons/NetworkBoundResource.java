package com.jamarfal.androidcertification.commons;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.jamarfal.androidcertification.commons.api_response.ApiErrorResponse;
import com.jamarfal.androidcertification.commons.api_response.ApiResponse;
import com.jamarfal.androidcertification.commons.api_response.ApiSuccessResponse;
import com.jamarfal.androidcertification.repository.datasource.DataSource;

public abstract class NetworkBoundResource<ResultType, RequestType> {

  private MediatorLiveData<Resource<ResultType>> result;
  private AppExecutor appExecutor;

  @MainThread
  public NetworkBoundResource(AppExecutor appExecutor) {
    this.appExecutor = appExecutor;

    result.setValue((Resource<ResultType>) Resource.loading(null));
    final LiveData<ResultType> dbSource = loadFromDb();
    result.addSource(dbSource, new Observer<ResultType>() {
      @Override
      public void onChanged(@Nullable ResultType data) {
        result.removeSource(dbSource);
        if (shouldFetch(data)) {

        }
      }
    });
  }

  private void fetchFromNetwork(final LiveData<ResultType> dbSource) {

    final LiveData<ApiResponse<RequestType>> apiResponse = createCall();

    result.addSource(dbSource, new Observer<ResultType>() {
      @Override
      public void onChanged(@Nullable ResultType newData) {
        setValue(Resource.loading(newData));
      }
    });

    result.addSource(apiResponse, new Observer<ApiResponse<RequestType>>() {
      @Override
      public void onChanged(@Nullable final ApiResponse<RequestType> response) {
        result.removeSource(apiResponse);
        result.removeSource(dbSource);

        if (response instanceof ApiSuccessResponse) {
          appExecutor.diskIO().execute(new Runnable() {
            @Override
            public void run() {
              saveCallResult(processResponse((ApiSuccessResponse<RequestType>) response));

              appExecutor.mainThread().execute(new Runnable() {
                @Override
                public void run() {
                  result.addSource(loadFromDb(), new Observer<ResultType>() {
                    @Override
                    public void onChanged(@Nullable ResultType newData) {
                      setValue(Resource.success(newData));
                    }
                  });
                }
              });
            }
          });
        } else {
          final ApiErrorResponse errorResponse = (ApiErrorResponse) response;
          onFetchFailed();
          result.addSource(dbSource, new Observer<ResultType>() {
            @Override
            public void onChanged(@Nullable ResultType newData) {
              setValue(Resource.error(errorResponse.getErrorMessage(), newData));
            }
          });
        }
      }
    });
  }

  @MainThread
  private void setValue(Resource<ResultType> newValue) {
    if (result.getValue() != newValue) {
      result.setValue(newValue);
    }
  }

  protected void onFetchFailed() {
  }

  @MainThread
  protected abstract LiveData<ResultType> loadFromDb();

  @MainThread
  protected abstract boolean shouldFetch(@Nullable ResultType data);

  @MainThread
  protected abstract LiveData<ApiResponse<RequestType>> createCall();

  @WorkerThread
  protected abstract void saveCallResult(RequestType data);

  @WorkerThread
  protected RequestType processResponse(ApiSuccessResponse<RequestType> response) {
    return response.getBody();
  }

  public LiveData<Resource<ResultType>> asLiveData() {
    return result;
  }
}

