package com.jamarfal.androidcertification.repository.datasource.db;

import com.jamarfal.androidcertification.MyApplication;
import com.jamarfal.androidcertification.repository.datasource.DataSourceProvider;

public class DbDataSourceProvider implements DataSourceProvider<FruitDataBase> {
  @Override
  public FruitDataBase getDataSource() {
    return FruitDataBase.getDatabase(MyApplication.get());
  }
}
