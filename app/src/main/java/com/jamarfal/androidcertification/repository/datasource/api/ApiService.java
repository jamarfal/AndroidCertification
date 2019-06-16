package com.jamarfal.androidcertification.repository.datasource.api;

import com.jamarfal.androidcertification.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
  private static Retrofit sRetrofitInstance = null;
  private static OkHttpClient sClient = null;

  private ApiService() {
  }

  public static void createRetrofitInstance() {
    if (sRetrofitInstance == null) {
      sRetrofitInstance = new Retrofit.Builder()
          .baseUrl(BuildConfig.URL)
          .client(getClientInstance())
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }
  }

  public static synchronized Retrofit getRetrofitInstance() {
    if (sRetrofitInstance == null) {
      createRetrofitInstance();
    }
    return sRetrofitInstance;
  }

  private static synchronized OkHttpClient getClientInstance() {
    if (sClient == null) {
      HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
      logger.setLevel(HttpLoggingInterceptor.Level.BASIC);
      sClient = new OkHttpClient.Builder()
          .addInterceptor(logger)
          .build();
    }
    return sClient;
  }
}
