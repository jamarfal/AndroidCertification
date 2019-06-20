package com.jamarfal.androidcertification.repository.datasource.db;

import android.arch.lifecycle.LiveData;
import com.jamarfal.androidcertification.repository.datasource.DataSource;
import java.util.List;

public class FruitCacheDataSource implements DataSource<LiveData<List<FruitEntityDbo>>> {

  DbDataSourceProvider dbDataSourceProvider;
  FruitDataBase fruitDataBase;

  public FruitCacheDataSource() {
    dbDataSourceProvider = new DbDataSourceProvider();
    fruitDataBase = dbDataSourceProvider.getDataSource();
  }

  @Override
  public LiveData<List<FruitEntityDbo>> getAllData() {
    return fruitDataBase.fruitDao().getAll();
  }

  @Override
  public LiveData<List<FruitEntityDbo>> getPaginatedData(int limit, int offset) {
    return null;
  }

  public void insert(final List<FruitEntityDbo> fruitsDboList) {
    if (!fruitsDboList.isEmpty()) {
      fruitDataBase.fruitDao().insert(fruitsDboList);
    }
  }
}
