package carsim;

public class AvailableState implements StaffState {
    @Override
    public boolean canHandleCommand() {
        return true;
    }

    @Override
    public StaffStateName getName() {
        return StaffStateName.AVAILABLE;
    }
}