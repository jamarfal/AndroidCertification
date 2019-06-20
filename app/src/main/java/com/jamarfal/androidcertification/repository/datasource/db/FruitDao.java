package com.jamarfal.androidcertification.repository.datasource.db;

import android.arch.lifecycle.LiveData;
import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import java.util.List;

@Dao
public interface FruitDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insert(List<FruitEntityDbo> fruitDboList);

  @Query("SELECT * FROM fruit_table")
  LiveData<List<FruitEntityDbo>> getAll();

  // PAGING
  @Query("SELECT * FROM fruit_table")
  DataSource.Factory<Integer, FruitEntityDbo> getAllPaginated();

  @Query("SELECT * FROM fruit_table WHERE item LIKE :fruitName")
  DataSource.Factory<Integer, FruitEntityDbo> getPagingByName(String fruitName);
}
