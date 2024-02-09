package com.hgrranzi.avajair;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static Logger logger;
    private final PrintWriter printWriter;
    private static final String LOG_PATH = "simulation.txt";

    private Logger() {
        try {
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter(LOG_PATH, false)));
        } catch (IOException exception) {
            throw new AvajairException("Could not initialize logger");
        }
    }

    public static Logger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String message) {
        printWriter.print(message);
        printWriter.flush();
    }

    public void close() {
        printWriter.close();
    }
}
