package com.hgrranzi.avajair;

public class AvajairApplication {

    public static void main(String[] args) {
        Simulation.run(args.length > 0 ? args[0] : null);
    }

}
