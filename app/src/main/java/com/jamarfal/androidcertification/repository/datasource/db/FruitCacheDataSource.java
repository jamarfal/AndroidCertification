package com.jamarfal.androidcertification.repository.datasource.db;

import com.jamarfal.androidcertification.repository.datasource.DataSource;
import java.util.List;

public class FruitCacheDataSource implements DataSource<FruitEntityDbo> {

  DbDataSourceProvider dbDataSourceProvider;
  FruitDataBase fruitDataBase;

  public FruitCacheDataSource() {
    dbDataSourceProvider = new DbDataSourceProvider();
    fruitDataBase = dbDataSourceProvider.getDataSource();
  }

  @Override
  public List<FruitEntityDbo> getAllData() {
    return fruitDataBase.fruitDao().getAll();
  }

  @Override
  public FruitEntityDbo getData(int id) {
    return null;
  }
}
