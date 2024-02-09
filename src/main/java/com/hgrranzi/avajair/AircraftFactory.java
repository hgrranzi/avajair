package com.hgrranzi.avajair;

public class AircraftFactory {

    private static int aircraftCreated = 0;

    public static Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        long id = ++aircraftCreated;
        switch (p_type) {
            case "Helicopter":
                return new Helicopter(id, p_name, p_coordinates);
            case "JetPlane":
                return new JetPlane(id, p_name, p_coordinates);
            case "Baloon":
                return new Baloon(id, p_name, p_coordinates);
            default:
                throw new RuntimeException(String.format("Cannot create an aircraft of type: %s", p_type));
        }
    }
}
