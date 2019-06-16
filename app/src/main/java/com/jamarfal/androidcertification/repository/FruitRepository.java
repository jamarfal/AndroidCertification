package com.jamarfal.androidcertification.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import com.jamarfal.androidcertification.commons.AppExecutor;
import com.jamarfal.androidcertification.commons.Resource;
import com.jamarfal.androidcertification.repository.datasource.FruitMapper;
import com.jamarfal.androidcertification.repository.datasource.api.FruitApiDataSource;
import com.jamarfal.androidcertification.repository.datasource.api.FruitDto;
import com.jamarfal.androidcertification.repository.datasource.db.FruitCacheDataSource;
import com.jamarfal.androidcertification.repository.datasource.db.FruitEntityDbo;
import java.util.ArrayList;
import java.util.List;

public class FruitRepository {
  private FruitApiDataSource fruitApiDataSource;
  private FruitCacheDataSource cacheDataSource;

  public FruitRepository() {
    fruitApiDataSource = new FruitApiDataSource();
    cacheDataSource = new FruitCacheDataSource();
  }

  public LiveData<Resource<List<Fruit>>> getAll() {
    fetchFruitFromNetwork();
    return transformCacheResponseToResourceResponse();
  }

  private MediatorLiveData<Resource<List<Fruit>>> transformCacheResponseToResourceResponse() {
    final MediatorLiveData<Resource<List<Fruit>>> resourceMediatorLiveData = new MediatorLiveData<>();
    resourceMediatorLiveData.postValue(Resource.loading(null));

    LiveData<List<FruitEntityDbo>> cachedLiveData = cacheDataSource.getAllData();
    resourceMediatorLiveData.addSource(cachedLiveData, fruitEntityDbos -> {
      List<Fruit> fruits = FruitMapper.dboToBO(fruitEntityDbos);
      resourceMediatorLiveData.postValue(Resource.success(fruits));
    });
    return resourceMediatorLiveData;
  }

  private void fetchFruitFromNetwork() {
    new AppExecutor().networkIO().execute(() -> {
      Resource<List<FruitDto>> allData = fruitApiDataSource.getAllData();
      cacheDataSource.insert(FruitMapper.dtoToDbo(allData.getData()));
    });
  }

  public void add(FruitEntityDbo fruitEntityDbo) {
    new AppExecutor().diskIO().execute(() ->{
      List<FruitEntityDbo> newFruits = new ArrayList<>();
      newFruits.add(fruitEntityDbo);
      cacheDataSource.insert(newFruits);
    });
  }
}
