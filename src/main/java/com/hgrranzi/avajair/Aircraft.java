package com.hgrranzi.avajair;

public abstract class Aircraft implements Flyable {

    private long id;
    private String name;
    private Coordinates coordinates;

    Aircraft(long id, String name, Coordinates coordinates) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {

    }
}
