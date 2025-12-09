package carsim;

public class USConvertible extends Convertible {
    // logic to build Convertible
    public USConvertible() {
        super();
        this.cost = 23000;
        assembleComponents();
    }

    public void assembleComponents() {
        this.engine = buildEngine();
        this.suspension = buildSuspension();
        this.tires = buildTires();
    }

    @Override
    public Engine buildEngine() {
        return new USRacingEngine();
    }

    @Override
    public Suspension buildSuspension() {
        return new USRacingSuspension();
    }

    @Override
    public Tires buildTires() {
        return new USRacingTires();
    }
}
