package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView welcomeText = findViewById(R.id.textView);
        Button forecastButton = findViewById(R.id.button);
        Button cityList = findViewById(R.id.button2);

        welcomeText.setText(getString(R.string.welcome_message));
        forecastButton.setText(getString(R.string.current_forecast_button));
        cityList.setText(getString(R.string.city_list_button));

        cityList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        forecastButton.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v){
                    String nombreCiudad = "Londres";
                    abrirDetailActivity(nombreCiudad);
            }
        });
    }

    private  void abrirDetailActivity(String nombreCiudad){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("cityName", nombreCiudad);
        startActivity(intent);
    }
}