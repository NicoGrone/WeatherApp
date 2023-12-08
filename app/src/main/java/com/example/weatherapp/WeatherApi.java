package com.example.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("data/2.5/weather")
    Call<WeatherResponse> getWeatherData (
            @Query("q") String cityName,
            @Query("appid") String apiKey,
            @Query ("lang") String lang,
            @Query ("units") String units
    );
}
