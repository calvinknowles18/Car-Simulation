package carsim;

public interface StaffState {
    boolean canHandleCommand();
    StaffStateName getName();

    default String getNameString() {
        switch (getName()) {
            case NOT_IN:
                return "NotIn";
            case ARRIVING:
                return "Arriving";
            case AVAILABLE:
                return "Available";
            case LUNCH:
                return "Lunch";
            default:
                return getName().name();
        }
    }
}