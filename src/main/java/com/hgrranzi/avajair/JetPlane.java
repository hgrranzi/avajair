package com.hgrranzi.avajair;

public class JetPlane extends Aircraft {

    public JetPlane(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public String getIfo() {
        return String.format("JetPlane#%s(%d)", this.name, this.id);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                adaptToConditions(0, 10, 2, "The SUN is up, the sky is blue, it's beautiful, and so are you!");
                break;
            case "RAIN":
                adaptToConditions(0, 5, 0, "I'm singing in the RAIN, just singing in the RAIN!");
                break;
            case "FOG":
                adaptToConditions(0, 1, 0, "The FOG was lifting a voice was chanting!");
                break;
            case "SNOW":
                adaptToConditions(0, 0, -7, "The SNOW glows white on the mountain tonight, not a footprint to be seen!");
                break;
        }

    }
}
