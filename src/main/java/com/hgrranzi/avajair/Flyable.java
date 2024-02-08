package com.hgrranzi.avajair;

public interface Flyable {

    void updateConditions();

    default void registerTower(WeatherTower weatherTower) {}
}
