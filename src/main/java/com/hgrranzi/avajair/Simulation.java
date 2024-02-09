package com.hgrranzi.avajair;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private static Tower tower;
    private static int numberOfIterations = 0;

    public static void run(String scenarioPath) {
        try {
            List<String> scenarioLines = parseScenario(scenarioPath);
            tower = new WeatherTower();
            lola(scenarioLines);
            for (int i = 0; i < numberOfIterations; i++) {
                tower.conditionChanged();
            }
        } catch (AvajairException exception) {
            System.out.println("ERROR: " + exception.getMessage());
        }
    }

    private static List<String> parseScenario(String scenarioPath) {
        List<String> lines = new ArrayList<>();
        // open scenario file
        // save scenario into list of lines
        // close scenario file
        return lines;
    }

    private static void lola(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new AvajairException("No lines to parse");
        }
        try {
            numberOfIterations = Integer.parseInt(lines.get(0));
            if (numberOfIterations <= 0) {
                throw new AvajairException("Number of iterations must be positive");
            }
        } catch (NumberFormatException e) {
            throw new AvajairException("First line is not a valid integer");
        }

        for (int i = 1; i < lines.size(); i++) {
            try {
                tower.register(parseAircraftInfo(lines.get(i), i + 1));
            } catch (AvajairCheckedException exception) {
                System.out.println("WARNING: Aircraft not registered: " + exception.getMessage());
            }
        }
    }

    private static Flyable parseAircraftInfo(String info, int lineNumber) throws AvajairCheckedException {
        String[] parts = info.split(" ");
        if (parts.length != 5) {
            throw new AvajairCheckedException("Incorrect data format on line " + lineNumber);
        }

        String type = parts[0];
        String name = parts[1];
        int longitude;
        int latitude;
        int height;

        try {
            longitude = Integer.parseInt(parts[2]);
            latitude = Integer.parseInt(parts[3]);
            height = Integer.parseInt(parts[4]);
        } catch (NumberFormatException e) {
            throw new AvajairCheckedException("Incorrect data format on line " + lineNumber);
        }
        if (longitude < 0 || latitude < 0 || height < 0) {
            throw new AvajairCheckedException("Negative coordinates on line " + lineNumber);
        }
        if (height > 100) {
            throw new AvajairCheckedException("Coordinates out of tower view on line " + lineNumber);
        }
        return AircraftFactory.newAircraft(type, name, new Coordinates(longitude, latitude, height));
    }
}
