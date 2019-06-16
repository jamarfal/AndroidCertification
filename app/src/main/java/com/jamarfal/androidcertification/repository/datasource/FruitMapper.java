package com.jamarfal.androidcertification.repository.datasource;

import android.support.annotation.Nullable;
import com.jamarfal.androidcertification.repository.Fruit;
import com.jamarfal.androidcertification.repository.datasource.api.FruitDto;
import com.jamarfal.androidcertification.repository.datasource.db.FruitEntityDbo;
import java.util.ArrayList;
import java.util.List;

public class FruitMapper {

  public static Fruit dboToBO(@Nullable FruitEntityDbo fruitDbo) {
    Fruit result = Fruit.EMPTY_FRUIT;

    if (fruitDbo != null) {
      result = new Fruit(
          fruitDbo.getId(),
          fruitDbo.getItem(),
          fruitDbo.getCategory(),
          fruitDbo.getFarmName(),
          fruitDbo.getPhone());
    }

    return result;
  }

  public static List<Fruit> dboToBO(List<FruitEntityDbo> bunchOfFruitDbo) {
    List<Fruit> bunchOfFruits = new ArrayList<>(bunchOfFruitDbo.size());
    for (FruitEntityDbo fruitDbo : bunchOfFruitDbo) {
      bunchOfFruits.add(dboToBO(fruitDbo));
    }
    return bunchOfFruits;
  }

  public static FruitEntityDbo dtoToDbo(FruitDto fruitDto) {
    FruitEntityDbo result = FruitEntityDbo.EMPTY_FRUIT;
    if (fruitDto != null) {
      result = new FruitEntityDbo(
          fruitDto.getId(),
          fruitDto.getItem(),
          fruitDto.getCategory(),
          fruitDto.getFarmName(),
          fruitDto.getPhone());
    }

    return result;
  }

  public static List<FruitEntityDbo> dtoToDbo(List<FruitDto> data) {
    List<FruitEntityDbo> bunchOfFruits = new ArrayList<>(data.size());
    for (FruitDto fruitDto : data) {
      bunchOfFruits.add(dtoToDbo(fruitDto));
    }
    return bunchOfFruits;
  }
}
