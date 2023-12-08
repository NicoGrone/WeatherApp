package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private TextView cityNameTextView;
    private TextView currentTemperatureTextView;
    private TextView weatherDescriptionTextView;
    private TextView minTemperatureTextView;
    private TextView maxTemperatureTextView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String cityName = intent.getStringExtra("cityName");

        cityNameTextView = findViewById(R.id.NombreCiudad);
        currentTemperatureTextView = findViewById(R.id.TemperaturaActual);
        weatherDescriptionTextView = findViewById(R.id.DescripcionClima);
        minTemperatureTextView = findViewById(R.id.TemperaturaMin);
        maxTemperatureTextView = findViewById(R.id.TemperaturaMax);

        new FetchWeatherDataTask().execute(cityName);
    }


    private class FetchWeatherDataTask extends AsyncTask<String, Void, WeatherResponse> {
        @Override
        protected WeatherResponse doInBackground(String... params){
            String cityName = params[0];
            String apiKey = "ca9530abcb9a3205b1f002a4831ec24b";

            WeatherApi weatherApi = RetrofitClient.getRetrofitInstance().create(WeatherApi.class);
            Call<WeatherResponse> call = weatherApi.getWeatherData(cityName, apiKey, "es","metric");

            try {
                Response<WeatherResponse> response = call.execute();
                if (response.isSuccessful()) {
                    return response.body();
                }
            }   catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onPostExecute(WeatherResponse weatherData){
        Intent intent = getIntent();
        String cityName = intent.getStringExtra("cityName");
        if(weatherData != null) {
            double currentTemp = weatherData.getMain().getTemp();
            String description = weatherData.getWeather().get(0).getDescription();
            double minTemp = weatherData.getMain().getTemp_min();
            double maxTemp = weatherData.getMain().getTemp_max();

            description = description.substring(0,1).toUpperCase() + description.substring(1).toLowerCase();

            cityNameTextView.setText("Nombre de ciudad: " + cityName);
            currentTemperatureTextView.setText("Temperatura actual: " + currentTemp + " °C");
            weatherDescriptionTextView.setText("Descripcion del clima: " + description);
            minTemperatureTextView.setText("Temperatura Minima: " + minTemp  + " °C");
            maxTemperatureTextView.setText("Temperatura Maxima: " + maxTemp  + " °C");

            }
        }
    }
}