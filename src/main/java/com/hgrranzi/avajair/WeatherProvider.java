package com.hgrranzi.avajair;

import java.util.Random;

// Singleton class
public class WeatherProvider {

    private static WeatherProvider instance = null;

    private static final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    public WeatherProvider getProvider() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        return weather[new Random().nextInt(4)];
    }
}
