package com.hgrranzi.avajair;

import java.util.ArrayList;
import java.util.List;

public class Tower {

    private final List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
        System.out.printf("Tower says: %s registered to weather tower.%n", p_flyable.getIfo());
    }

    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
        System.out.printf("Tower says: %s unregistered from weather tower.%n", p_flyable.getIfo());
    }

    protected void conditionChanged() {
        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }
    }
}
