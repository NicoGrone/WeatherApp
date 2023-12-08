package com.example.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.weatherapp.R;


import java.util.ArrayList;
public class MyAdapter extends ArrayAdapter<String> {
    public MyAdapter(Context context, ArrayList<String> cities) {super (context, 0, cities);}
    @Override

    public View getView (int position, View convertView, ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        String cityName = getItem(position);
        TextView cityNameTextView = convertView.findViewById(R.id.cityName);
        cityNameTextView.setText(cityName);

        return convertView;

    }
}
