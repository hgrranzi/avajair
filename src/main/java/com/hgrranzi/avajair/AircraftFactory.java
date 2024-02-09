package com.hgrranzi.avajair;

public class AircraftFactory {

    private static int aircraftCreated = 0;

    public static Flyable newAircraft(String type, String name, Coordinates coordinates) throws AvajairCheckedException {
        long id = ++aircraftCreated;
        switch (type) {
            case "Helicopter":
                return new Helicopter(id, name, coordinates);
            case "JetPlane":
                return new JetPlane(id, name, coordinates);
            case "Baloon":
                return new Baloon(id, name, coordinates);
            default:
                throw new AvajairCheckedException(String.format("Cannot create an aircraft of type: %s", type));
        }
    }
}
