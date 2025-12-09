package org.coursera.lab.capstone;

public class ArrivingState implements StaffState {
    @Override
    public boolean canHandleCommand() {
        return true;
    }

    @Override
    public StaffStateName getName() {
        return StaffStateName.ARRIVING;
    }
}