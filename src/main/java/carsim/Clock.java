package carsim;

import java.util.ArrayList;
import java.util.List;

public class Clock {
    // Create instance immediately (eager)
    private static final Clock instance = new Clock();
    
    // Observer declaration
    private List<ClockObserver> observers = new ArrayList<>();

    // Time tracker initial state
    private int currentDay = 1;  // Start on Day 1
    private int currentHour = 8; // Start at 8 AM

    // Private constructor to prevent external construction
    private Clock () {}

    public static Clock getInstance() {
        return instance;
    }

    public void registerObserver(ClockObserver obs) {
        observers.add(obs);
    }

    public void notifyObservers() {
        for (ClockObserver o : observers) {
            o.update(currentDay, currentHour);
        }
    }

    public void tick() {
        // Announce the time
        printTime();

        // Notify the staff
        notifyObservers();

        // Advance the time by an hour
        if (currentHour == 12) {
            currentHour = 1;  // Shift into PM from AM
        } else if (currentHour == 7) {
            // End of the day so increment Day and reset clock to 9
            currentDay++;
            currentHour = 8;
        } else {
            // increment the hour
            currentHour++;
        }
    }

    private void printTime() {
        String ampm = (currentHour >= 8 && currentHour <= 11) ? "AM" : "PM";
        System.out.println("Time now: " + currentHour + " " + ampm);
    }

    // Getters
    public int getCurrentHour() {
        return currentHour;
    }

    public int getCurrentDay() {
        return currentDay;
    }
}