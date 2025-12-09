package org.coursera.lab.capstone;

public class LunchState implements StaffState {
    @Override
    public boolean canHandleCommand() {
        return false;
    }

    @Override
    public StaffStateName getName() {
        return StaffStateName.LUNCH;
    }
}