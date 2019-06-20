package com.jamarfal.androidcertification.repository.datasource;

public interface DataSource<T> {
  T getAllData();

  T getPaginatedData(int limit, int offset);
}
