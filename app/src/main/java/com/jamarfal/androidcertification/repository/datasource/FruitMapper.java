package com.jamarfal.androidcertification.repository.datasource;

import com.jamarfal.androidcertification.repository.Fruit;
import com.jamarfal.androidcertification.repository.datasource.db.FruitEntityDbo;
import java.util.ArrayList;
import java.util.List;

public class FruitMapper {

  public static Fruit dboToBO(FruitEntityDbo fruitEntityDbo) {
    return new Fruit();
  }

  public static List<Fruit> dboToBO(List<FruitEntityDbo> bunchOfFruitDbo) {
    List<Fruit> bunchOfFruits = new ArrayList<>(bunchOfFruitDbo.size());
    return bunchOfFruits;
  }
}
