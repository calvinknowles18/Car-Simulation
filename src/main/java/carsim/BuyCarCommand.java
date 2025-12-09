package carsim;

public class BuyCarCommand implements Command {
    private Staff staff;
    private Car car;

    public BuyCarCommand(Staff staff, Car car) {
        this.staff = staff;
        this.car = car;
    }

    @Override
    public void execute() {
        staff.buyCar(car);
    }
}