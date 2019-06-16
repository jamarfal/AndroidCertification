package com.jamarfal.androidcertification.repository;

import android.arch.lifecycle.LiveData;
import android.support.annotation.Nullable;
import com.jamarfal.androidcertification.commons.AppExecutor;
import com.jamarfal.androidcertification.commons.NetworkBoundResource;
import com.jamarfal.androidcertification.commons.Resource;
import com.jamarfal.androidcertification.commons.api_response.ApiResponse;
import com.jamarfal.androidcertification.repository.datasource.DataSource;
import com.jamarfal.androidcertification.repository.datasource.FruitMapper;
import com.jamarfal.androidcertification.repository.datasource.api.FruitApiDataSource;
import com.jamarfal.androidcertification.repository.datasource.api.FruitDto;
import com.jamarfal.androidcertification.repository.datasource.db.FruitCacheDataSource;
import com.jamarfal.androidcertification.repository.datasource.db.FruitEntityDbo;
import java.util.List;

public class FruitRepository {

  private DataSource<FruitDto> apiDataSource;
  private DataSource<FruitEntityDbo> cacheDataSource;
  private AppExecutor appExecutor;

  public FruitRepository() {
    apiDataSource = new FruitApiDataSource();
    cacheDataSource = new FruitCacheDataSource();
    appExecutor = new AppExecutor();
  }

  public LiveData<Resource<Fruit>> getAll() {
    NetworkBoundResource<List<Fruit>, List<FruitDto>> networkBoundResource =
        new NetworkBoundResource<List<Fruit>, List<FruitDto>>() {
          @Override
          protected LiveData<List<Fruit>> loadFromDb() {
            List<FruitEntityDbo> allData = cacheDataSource.getAllData();
            return FruitMapper.dboToBO(allData);
          }

          @Override
          protected boolean shouldFetch(@Nullable List<Fruit> data) {
            return false;
          }

          @Override
          protected LiveData<ApiResponse<List<FruitDto>>> createCall() {
            return null;
          }

          @Override
          protected void saveCallResult(List<FruitDto> data) {

          }
        }
    return fruitFruitDtoNetworkBoundResource.asLiveData();
  }
}
