package com.jamarfal.androidcertification.repository.datasource.api;

import com.google.gson.annotations.SerializedName;

public class FruitDto {

  @SerializedName("farmer_id")
  private String id;

  @SerializedName("item")
  private String item;

  @SerializedName("category")
  private String category;

  @SerializedName("farm_name")
  private String farmName;

  @SerializedName("phone1")
  private String phone;

  public String getId() {
    return id;
  }

  public String getItem() {
    return item;
  }

  public String getCategory() {
    return category;
  }

  public String getFarmName() {
    return farmName;
  }

  public String getPhone() {
    return phone;
  }
}
