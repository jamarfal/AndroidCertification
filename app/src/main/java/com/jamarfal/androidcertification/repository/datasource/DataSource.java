package com.jamarfal.androidcertification.repository.datasource;

import java.util.List;

public interface DataSource<T> {

  public List<T> getAllData();

  public T getData(int id);
}
