package com.jamarfal.androidcertification.repository.datasource.api;

import com.jamarfal.androidcertification.repository.datasource.DataSourceProvider;

public class ApiDataSourceProvider implements DataSourceProvider<FruitService> {
  
  @Override
  public FruitService getDataSource() {
    return ApiService.getRetrofitInstance().create(FruitService.class);
  }
}
