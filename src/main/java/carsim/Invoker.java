package carsim;

public class Invoker {
    private static Invoker instance;
    //private Staff[] staff;
    //private Random random = new Random();

    public enum RequestType { ORDER, SERVICE, BUY}

    private Invoker() {}

    
    
    public static Invoker getInstance() {
        if (instance == null) {
            instance = new Invoker();
        }
        return instance;
    }

    public void handleRequest(RequestType type, Car car, Staff chosen) {
        
        Command cmd;

        switch (type) {
            case ORDER:
                cmd = new OrderCarCommand(chosen, car);
                break;
            case SERVICE:
                cmd = new ServiceCarCommand(chosen, car);
                break;
            case BUY:
            default:
                cmd = new BuyCarCommand(chosen, car);
                break;
        }

        cmd.execute(); // call the command
    }
}