package carsim;

public abstract class Coupe extends Car {
    // Default: safety handling
    public Coupe() {
        super("coupe");
    }

    public abstract Engine buildEngine();
    public abstract Suspension buildSuspension();
    public abstract Tires buildTires();

    public void assembleComponents() {
        this.engine = buildEngine();
        this.suspension = buildSuspension();
        this.tires = buildTires();
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