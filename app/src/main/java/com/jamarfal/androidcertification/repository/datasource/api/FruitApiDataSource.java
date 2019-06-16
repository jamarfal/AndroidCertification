package com.jamarfal.androidcertification.repository.datasource.api;

import com.jamarfal.androidcertification.commons.Logger;
import com.jamarfal.androidcertification.commons.Resource;
import com.jamarfal.androidcertification.repository.datasource.DataSource;
import java.io.IOException;
import java.util.List;
import retrofit2.Call;
import retrofit2.Response;

public class FruitApiDataSource implements DataSource<Resource<List<FruitDto>>> {

  private ApiDataSourceProvider apiDataSourceProvider;

  public FruitApiDataSource() {
    this.apiDataSourceProvider = new ApiDataSourceProvider();
  }

  @Override
  public Resource<List<FruitDto>> getAllData() {
    Resource<List<FruitDto>> result;
    Call<List<FruitDto>> fruitsCall = apiDataSourceProvider.getDataSource().getFruits("Pick Your Own", 1, 0);

    try {
      Response<List<FruitDto>> response = fruitsCall.execute();
      if (response.isSuccessful()) {
        List<FruitDto> fruits = response.body();
        result = Resource.success(fruits);
      } else {
        result = Resource.error("Error al realizar la request", null);
      }
    } catch (IOException exception) {
      String errorMessage = exception.getMessage();
      Logger.logError(errorMessage);
      result = Resource.error(errorMessage, null);
    }

    return result;
  }
}
