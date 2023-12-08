package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_list);
        ListView cityListView = findViewById(R.id.cityListView);
        ArrayList <String> cityNames= new ArrayList<>();
        cityNames.add("Buenos Aires");
        cityNames.add("Washington DC");
        cityNames.add("Oslo");
        cityNames.add("Londres");
        cityNames.add("Madrid");

        MyAdapter adapter = new MyAdapter(this, cityNames);
        cityListView.setAdapter(adapter);

        cityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedCity = cityNames.get(position);
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                intent.putExtra("cityName", selectedCity);
                startActivity(intent);
            }
        });
      }
    }
