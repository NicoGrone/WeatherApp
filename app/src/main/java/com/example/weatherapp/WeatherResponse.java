package com.example.weatherapp;

import java.util.List;

public class WeatherResponse {

    private MainData main;
    private List<WeatherDescription> weather;

    public MainData getMain() {return main;}

    public List<WeatherDescription> getWeather() {return weather;}

    public static class MainData {
        private double temp;
        private double temp_min;
        private double temp_max;

        public double getTemp() {return temp;}
        public double getTemp_min(){return temp_min;}
        public double getTemp_max(){return temp_max;}
    }

    public static class WeatherDescription {
        private String description;
        public String getDescription() {return description;}
    }
}
