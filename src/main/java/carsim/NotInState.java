package carsim;

public class NotInState implements StaffState {
    @Override
    public boolean canHandleCommand() {
        return false;
    }

    @Override
    public StaffStateName getName() {
        return StaffStateName.NOT_IN;
    }
}