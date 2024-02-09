package com.hgrranzi.avajair;

public class Helicopter extends Aircraft {

    public Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public String getIfo() {
        return String.format("Helicopter#%s(%d)", this.name, this.id);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                adaptToConditions(0, 10, 2, "SUN is shining, the weather is sweet, make you want to move your dancing" +
                                                " feet!");
                break;
            case "RAIN":
                adaptToConditions(0, 5, 0, "When the RAIN washes you clean, you'll know!");
                break;
            case "FOG":
                adaptToConditions(0, 1, 0, "Lost in a FOG, these hollow hills!");
                break;
            case "SNOW":
                adaptToConditions(0, 0, -12, "Let it SNOW, let it SNOW, let it SNOW!");
                break;
        }
    }
}
