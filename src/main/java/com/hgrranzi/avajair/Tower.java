package com.hgrranzi.avajair;

import java.util.ArrayList;
import java.util.List;

import static com.hgrranzi.avajair.Logger.getLogger;

public class Tower {

    private final List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
        getLogger().log(String.format("Tower says: %s registered to weather tower.%n", p_flyable.getIfo()));
    }

    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
        getLogger().log(String.format("Tower says: %s unregistered from weather tower.%n", p_flyable.getIfo()));
    }

    protected void conditionChanged() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }
}
