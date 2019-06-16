package com.jamarfal.androidcertification.repository.datasource.api;

import com.jamarfal.androidcertification.commons.Logger;
import com.jamarfal.androidcertification.repository.datasource.DataSource;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import retrofit2.Call;

public class FruitApiDataSource implements DataSource<FruitDto> {

  private ApiDataSourceProvider apiDataSourceProvider;

  public FruitApiDataSource() {
    this.apiDataSourceProvider = new ApiDataSourceProvider();
  }

  @Override
  public List<FruitDto> getAllData() {
    Call<List<FruitDto>> fruitsCall = apiDataSourceProvider.getDataSource().getFruits("", 0, 0);
    List<FruitDto> bunchOfFruits = Collections.emptyList();
    try {
      bunchOfFruits = fruitsCall.execute().body();
    } catch (IOException e) {
      Logger.logError(e.getMessage());
    }
    return bunchOfFruits;
  }

  @Override
  public FruitDto getData(int id) {
    return null; // Not implemented for the moment
  }
}
