package com.jamarfal.androidcertification.repository.datasource.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import java.util.List;

@Dao
public interface FruitDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insert(List<FruitEntityDbo> fruitDboList);

  @Delete
  void delete(List<FruitEntityDbo> fruitDboList);

  @Query("DELETE FROM fruit_table")
  void deleteAll();

  @Query("SELECT * FROM fruit_table")
  LiveData<List<FruitEntityDbo>> getAll();

  @Query("SELECT * FROM fruit_table WHERE farmer_id = :id")
  LiveData<FruitEntityDbo> getById(String id);

  @Query("SELECT * FROM fruit_table LIMIT :limit OFFSET :offset")
  List<FruitEntityDbo> get(int limit, int offset);

  @Query("SELECT * FROM fruit_table LIMIT :limit OFFSET :offset")
  LiveData<List<FruitEntityDbo>> getAsync(int limit, int offset);

  @Query("SELECT COUNT(item) FROM fruit_table LIMIT :limit OFFSET :offset")
  LiveData<Integer> count(int limit, int offset);
}
