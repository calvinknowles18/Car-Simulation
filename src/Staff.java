package org.coursera.lab.capstone;

public class Staff implements ClockObserver {

    public enum StaffStateName { NOT_IN, ARRIVING, AVAILABLE, LUNCH}

    private String name;
    private int arrivalTime;
    private int lunchTime;
    private int leaveTime;

    // State pattern
    private StaffState currentState;

    // Stat tracking
    private int orders;
    private int services;
    private int sales;
    private double bonus;

    public Staff(String name, int arrivalTime, int lunchTime, int leaveTime) {
        this.name = name;
        this.arrivalTime = toAbsoluteHour(arrivalTime);
        this.lunchTime = toAbsoluteHour(lunchTime);
        this.leaveTime = toAbsoluteHour(leaveTime);

        // Initial Staff state is NOT_IN
        this.currentState = new NotInState();
    }
    
    @Override
    public void update(int day, int hour) {
        // convert 8–12,1–7 → 8–19
        int absHour = toAbsoluteHour(hour);

        StaffState newState = determineState(absHour);

        if (newState.getName() != currentState.getName()) {
            currentState = newState;
            System.out.println(name + " moved to "
                    + currentState.getNameString() + " at " + hour);
        }
    }

    private StaffState determineState(int absHour) {
        if (absHour < arrivalTime || absHour >= leaveTime) {
            return new NotInState();
        } else if (absHour == arrivalTime) {
            return new ArrivingState();
        } else if (absHour == lunchTime) {
            return new LunchState();
        } else {
            return new AvailableState();
        }
    }

    public boolean canHandleCommand() {
        return currentState.canHandleCommand();
    }

    private int toAbsoluteHour(int hour) {
        // 8–12 stay 8–12; 1–7 become 13–19
        if (hour >= 8 && hour <= 12) {
            return hour;
        } else {
            return hour + 12; // 1 → 13, 4 → 16, etc.
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getOrders() {
        return orders;
    }

    public int getServices() {
        return services;
    }

    public int getSales() {
        return sales;
    }

    public double getBonus() {
        return bonus;
    }

    public void orderCar(Car car) {
        // order a Car logic w/ 3% bonus
        System.out.println(name + " is ordering " + car.getName() + " for $" + car.getCost());
        orders++; // increment orders
        bonus += 0.03 * car.getCost(); // running sum with bonus
        
    }

    public void serviceCar(Car car) {
        // service a Car logic w/ 1% bonus
        System.out.println(name + " is servicing " + car.getName() + " for $" + car.getCost());
        services++; // increment services
        bonus += 0.01 * car.getCost(); // running sum with bonus
    }

    public void buyCar(Car car) {
        // purchase a Car logic w/ 2% bonus
        System.out.println(name + " is buying " + car.getName() + " for $" + car.getCost());
        sales++; // increment sales
        bonus += 0.02 * car.getCost(); // running sum with bonus
    }
}