package com.jamarfal.androidcertification.repository;

import java.util.Objects;

public class Fruit {

  public static final Fruit EMPTY_FRUIT = new Fruit("-1", "", "", "", "");

  private String id;
  private String item;
  private String category;
  private String farmName;
  private String phone;

  public Fruit(String id, String item, String category, String farmName, String phone) {
    this.id = id;
    this.item = item;
    this.category = category;
    this.farmName = farmName;
    this.phone = phone;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Fruit fruit = (Fruit) o;
    return Objects.equals(id, fruit.id) &&
        Objects.equals(item, fruit.item) &&
        Objects.equals(category, fruit.category) &&
        Objects.equals(farmName, fruit.farmName) &&
        Objects.equals(phone, fruit.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, item, category, farmName, phone);
  }
}
