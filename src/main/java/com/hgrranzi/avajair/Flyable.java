package com.hgrranzi.avajair;

public abstract class Flyable {

    protected WeatherTower weatherTower;

    public abstract void updateConditions();

    public abstract String getIfo();

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
