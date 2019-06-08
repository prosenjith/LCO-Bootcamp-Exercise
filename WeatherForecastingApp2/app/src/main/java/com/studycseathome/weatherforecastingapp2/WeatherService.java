package com.studycseathome.weatherforecastingapp2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("data/2.5/forecast?")
    Call<ForecastResponse> getCurrentWeatherData(@Query("lat") double lat, @Query("lon") double lon,@Query("cnt") int cnt,@Query("APPID") String app_id);

}
