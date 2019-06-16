package com.jamarfal.androidcertification;

import android.app.Application;
import com.jamarfal.androidcertification.repository.datasource.api.ApiService;

public class MyApplication extends Application {

  private static MyApplication sMyApplication;

  @Override
  public void onCreate() {
    super.onCreate();
    ApiService.createRetrofitInstance();
    sMyApplication = this;
  }

  public static MyApplication get() {
    return sMyApplication;
  }
}
