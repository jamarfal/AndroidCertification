package com.jamarfal.androidcertification.repository.datasource.api;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FruitService {

  @GET("resource/hma6-9xbg.json")
  Call<List<FruitDto>> getFruits(
      @Query("category") String category,
      @Query("$limit") int limit,
      @Query("$offset") int offset);

  // Call<List<FruitDto>> getFruits();
}
