package com.hgrranzi.avajair;

import java.time.Instant;

// Singleton class
public class WeatherProvider {

    private static WeatherProvider instance = null;

    private static final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        int index = ((int) Instant.now().toEpochMilli()
                         / (p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight()))
                        % 4;
        return weather[index];
    }
}
