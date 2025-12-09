package carsim;

public class OrderCarCommand implements Command {
    private Staff staff;
    private Car car;

    public OrderCarCommand(Staff staff, Car car) {
        this.staff = staff;
        this.car = car;
    }

    @Override
    public void execute() {
        staff.orderCar(car);
    }
}