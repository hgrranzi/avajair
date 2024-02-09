package com.hgrranzi.avajair;

public class Baloon extends Aircraft {

    public Baloon(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public String getIfo() {
        return String.format("Baloon#%s(%d)", this.name, this.id);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                adaptToConditions(2, 0, 4, "Here comes the SUN, and I say, it's all right!");
                break;
            case "RAIN":
                adaptToConditions(0, 0, -5, "Here comes the RAIN again, falling on my head like a memory!");
                break;
            case "FOG":
                adaptToConditions(0, 0, -3, "FOG's rollin' in off the East River bank!");
                break;
            case "SNOW":
                adaptToConditions(0, 0, -15, "When the SNOW falls outside, you can hold me tight!");
                break;
        }
    }
}
