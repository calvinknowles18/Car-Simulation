package carsim;

public class Car {
    String type;
    String name;
    int cost;
    // HandlingBehavior handling;  // Strategy
    Engine engine;
    Suspension suspension;
    Tires tires;

    protected static int carCounter = 0;

    Car(String type) {
        carCounter++;
        this.type = type;
        name = type + " " + carCounter;

        // Default handling
        // this.handling = new SafetyHandling();
        
        // Keep switch for cost 
        switch (this.type) {
            case "sedan":
                this.cost = 10000; break;
            case "coupe":
                this.cost = 15000; break;
            case "convertible":
                this.cost = 20000; break;
            default:
                this.cost = 0;
        }
    }

    //public void setHandling(HandlingBehavior handling) {
    //    this.handling = handling;
    //}

    // Delegate work to Strategy
    //public void handle() {
    //    handling.handle(); // apply Strategy
    //};

    public String getComponents() {
        String engineInfo = (engine != null) ? engine.getInfo() : "None";
        String suspensionInfo = (suspension != null) ? suspension.getInfo() : "None";
        String tiresInfo = (tires != null) ? tires.getInfo() : "None";

        return "Engine: " + engineInfo +
                ", Suspension: " + suspensionInfo +
                ", Tires: " + tiresInfo;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public Engine getEngine() {
        return engine;
    }

    public Suspension getSuspension() {
        return suspension;
    }

    public Tires getTires() {
        return tires;
    }
}