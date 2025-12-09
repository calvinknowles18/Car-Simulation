package carsim;

public class ServiceCarCommand implements Command {
    private Staff staff;
    private Car car;

    public ServiceCarCommand(Staff staff, Car car) {
        this.staff = staff;
        this.car = car;
    }

    @Override
    public void execute() {
        staff.serviceCar(car);
    }
}