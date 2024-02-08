package com.hgrranzi.avajair;

public class AircraftFactory {

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        switch (p_type) {
            case "Helicopter":
                return new Helicopter(p_name, p_coordinates);
            case "JetPlane":
                return new JetPlane(p_name, p_coordinates);
            case "Baloon":
                return new Baloon(p_name, p_coordinates);
            default:
                throw new RuntimeException(String.format("Cannot create an aircraft of type: %s", p_type));
        }
    }
}
