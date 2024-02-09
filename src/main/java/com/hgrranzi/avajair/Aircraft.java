package com.hgrranzi.avajair;

public abstract class Aircraft extends Flyable {

    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long id, String name, Coordinates coordinates) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
    }

    public boolean isReadyToLand() {
        return coordinates.getHeight() == 0;
    }

    protected void land() {
        System.out.printf("%s landing.%n", this.getIfo());
        this.weatherTower.unregister(this);
        this.weatherTower = null;
    }

    protected void adaptToConditions(int longitude, int latitude, int height, String message) {
        System.out.printf("%s%s%n", this.getIfo(), message);
        int newHeight = this.coordinates.getHeight() + height < 0 ? 0
                : Math.min(this.coordinates.getHeight() + height, 100);
        this.coordinates = new Coordinates(
                this.coordinates.getLongitude() + longitude,
                this.coordinates.getLatitude() + latitude,
                newHeight
        );
        if (this.isReadyToLand()) {
            this.land();
        }
    }

}
