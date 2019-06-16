package com.jamarfal.androidcertification.repository.datasource.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = { FruitEntityDbo.class }, version = 1, exportSchema = false)
public abstract class FruitDataBase extends RoomDatabase {

  public abstract FruitDao fruitDao();

  private static FruitDataBase sInstance;

  public static FruitDataBase getDatabase(final Context context) {

    if (sInstance == null) {

      synchronized (FruitDataBase.class) {

        if (sInstance == null) {
          sInstance = Room.databaseBuilder(context.getApplicationContext(),
              FruitDataBase.class, "fruit_database")
              .fallbackToDestructiveMigration()
              .build();
        }
      }
    }

    return sInstance;
  }
}
