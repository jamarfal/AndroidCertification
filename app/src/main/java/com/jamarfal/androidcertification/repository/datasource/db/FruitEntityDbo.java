package com.jamarfal.androidcertification.repository.datasource.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity(tableName = "fruit_table", primaryKeys = {"farmer_id", "item"})
public class FruitEntityDbo {

  public static final FruitEntityDbo EMPTY_FRUIT = new FruitEntityDbo("-1", "", "", "", "");

  @NonNull
  @ColumnInfo(name = "farmer_id")
  private String id;

  @NonNull
  @ColumnInfo(name = "item")
  private String item;

  @ColumnInfo(name = "category")
  private String category;

  @ColumnInfo(name = "farmName")
  private String farmName;

  @ColumnInfo(name = "phone")
  private String phone;

  public FruitEntityDbo(@NonNull String id, @NonNull String item, String category, String farmName, String phone) {
    this.id = id;
    this.item = item;
    this.category = category;
    this.farmName = farmName;
    this.phone = phone;
  }

  @NonNull
  public String getId() {
    return id;
  }

  public void setId(@NonNull String id) {
    this.id = id;
  }

  @NonNull
  public String getItem() {
    return item;
  }

  public void setItem(@NonNull String item) {
    this.item = item;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getFarmName() {
    return farmName;
  }

  public void setFarmName(String farmName) {
    this.farmName = farmName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
