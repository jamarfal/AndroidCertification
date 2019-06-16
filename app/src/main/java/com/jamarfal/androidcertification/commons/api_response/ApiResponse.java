package com.jamarfal.androidcertification.commons.api_response;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.jamarfal.androidcertification.commons.Logger;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Response;

public abstract class ApiResponse<T> {

  @NonNull
  public static <T> ApiResponse<T> create(@Nullable Response<T> response) {
    ApiResponse apiResponse = new ApiErrorResponse("unknown error");

    if (response != null) {
      if (response.isSuccessful()) {
        ApiSuccessResponse success = new ApiSuccessResponse(response.body());
      } else {
        String errorMessage = response.message();
        ResponseBody responseBody = response.errorBody();
        if (responseBody != null) {
          String message = null;
          try {
            message = responseBody.string();
          } catch (IOException e) {
            Logger.logError(e.getMessage());
            errorMessage = "unknown error";
          }
          if (!TextUtils.isEmpty(message)) {
            errorMessage = message;
          }
        }
      }
    }

    return apiResponse;
  }
}
