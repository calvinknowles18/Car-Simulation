package org.coursera.lab.capstone;

import java.util.Random;

// add your classes to extend your prior command code
// to be able to use the state, singleton, and observer patterns
//
// see below for the main client code from the example
// use something similar for your own testing and for
// structuring your classes and subclasses
//
// see the test code for the autograder expectations

public class Main {
    public static void main(String[] args) {
        // use the main to invoke the simulation
        Simulation s = new Simulation();
        s.run();
    }
}

class Simulation {

    // get singleton references to Clock and Invoker
    private Invoker invoker;
    private Clock clock;
    Staff[] staff;
    private Random random = new Random();

    public Simulation() {
        clock = Clock.getInstance();

        staff = createStaff();
        for (Staff s : staff) {
            clock.registerObserver(s);
        }

        invoker = Invoker.getInstance();
    }

    public void run() {
        // create factories for car builds
        USFactory usFactory = new USFactory();
        JapanFactory japanFactory = new JapanFactory();

        // Simulate 10 days of commands
        for (int day = 1; day <= 10; day++) {
            System.out.println("Day " + day);

            for (int h = 0; h < 12; h++) {
                // increment the clock and let it notify the staff of new time
                clock.tick();

                // (this uses Observer to drive State updates)
                // no one works at 7 PM, otherwise handle this hour's customer
                int hour = clock.getCurrentHour();

                if (hour == 7) {
                    System.out.println("Nobody works at 7 PM");
                    continue; // move to next hour
                }
                
                // pick a random command
                Invoker.RequestType type = randomRequestType();

                // create a random car instance
                Car car = createRandomCar(usFactory, japanFactory);

                // pick a staff member and check their state
                Staff chosen = pickAvailableStaff();

                // if available, keep going
                // if not available, pick next staff member
                if (chosen == null) {
                    System.out.println("No staff available to handle the request at hour " + hour);
                    continue;
                }

                // have invoker set and make the request (command)
                invoker.handleRequest(type, car, chosen);

                // continue clock increments until 7 PM
                continue;
            }
        }
        // Display results by staff member
        printResults();

    }
    
    // Create Staff Helper
    private Staff[] createStaff() {
        // Name, ArrivalTime, LunchTime, LeaveTime
        Staff ann = new Staff("Ann", 8, 12, 4);
        Staff bob = new Staff("Bob", 9, 1, 5);
        Staff cal = new Staff("Cal", 10, 2, 6);
        Staff deb = new Staff("Deb", 11, 3, 7);

        return new Staff[] { ann, bob, cal, deb };
    }
    
    private Staff pickAvailableStaff() {
        int n = staff.length;

        // Start at a random index
        int start = random.nextInt(n);

        for (int i = 0; i < n; i++) {
            Staff candidate = staff[(start + i) % n];
            if (candidate.canHandleCommand()) {
                return candidate;
            }
        }

        return null; // If no staff are available
    }

    // Create Random Car Helper
    private Car createRandomCar(USFactory usFactory, JapanFactory japanFactory) {
        // Random region -> US or Japan
        // 0 = US, 1 = Japan
        int region = random.nextInt(2);

        // Random Car type -> Sedan or Coupe or Convertible
        // 0 = Sedan, 1 = Coupe, 2 = Covertible
        int carType = random.nextInt(3);

        if (region == 0) {
            switch (carType) {
                case 0:
                    return usFactory.createSedan(); // Create US Sedan
                case 1:
                    return usFactory.createCoupe(); // Create US Coupe
                default:
                    return usFactory.createConvertible(); // Create US Convertible
            }
        }
        else {
            switch (carType) {
                case 0:
                    return japanFactory.createSedan(); // Create Japan Sedan
                case 1:
                    return japanFactory.createCoupe(); // Create Japan Coupe
                default:
                    return japanFactory.createConvertible(); // Create Japan Convertible
            }
        }
    }

    private Invoker.RequestType randomRequestType() {
        int rand = random.nextInt(3);
        switch (rand) {
            case 0:
                return Invoker.RequestType.ORDER;
            case 1:
                return Invoker.RequestType.SERVICE;
            default:
                return Invoker.RequestType.BUY;
        }
    }

    private void printResults() {
        System.out.println("Results:");

        for (Staff s : staff) {
            System.out.println(s.getName() + ":");
            System.out.println("  Orders: " + s.getOrders());
            System.out.println("  Services: " + s.getServices());
            System.out.println("  Sales: " + s.getSales());
            System.out.println("  Bonus: $" + (int) s.getBonus());
        }
    }

}
