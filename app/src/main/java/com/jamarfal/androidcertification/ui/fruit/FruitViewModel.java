package com.jamarfal.androidcertification.ui.fruit;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;
import com.jamarfal.androidcertification.commons.Resource;
import com.jamarfal.androidcertification.repository.Fruit;
import com.jamarfal.androidcertification.repository.FruitRepository;
import com.jamarfal.androidcertification.repository.datasource.db.FruitEntityDbo;
import java.util.List;

public class FruitViewModel extends AndroidViewModel {

  private FruitRepository fruitRepository;

  public FruitViewModel(@NonNull Application application) {
    super(application);
    fruitRepository = new FruitRepository();
  }

  LiveData<Resource<List<Fruit>>> getFruits() {
    return fruitRepository.getAll();
  }

  LiveData<PagedList<Fruit>> getFruitsPaginated() {
    return fruitRepository.getAllPaginated();
  }


  public void add() {
    FruitEntityDbo fruitEntityDbo = new FruitEntityDbo("123", "Item nueov", "Cateogria nueva", "José Alberto", "Tlf");
    fruitRepository.add(fruitEntityDbo);
  }
}
