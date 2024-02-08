package com.hgrranzi.avajair;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates p_coordinated) {
        return WeatherProvider.getProvider().getCurrentWeather(p_coordinated);
    }

    public void changeWeather() {
       conditionChanged();
    }

}
