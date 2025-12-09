package carsim;

public class USSedan extends Sedan {
    // logic to build Sedan
    public USSedan() {
        super();
        this.cost = 13000;
        assembleComponents();
    }

    public void assembleComponents() {
        this.engine = buildEngine();
        this.suspension = buildSuspension();
        this.tires = buildTires();
    }

    @Override
    public Engine buildEngine() {
        return new USStandardEngine();
    }

    @Override
    public Suspension buildSuspension() {
        return new USStandardSuspension();
    }

    @Override
    public Tires buildTires() {
        return new USStandardTires();
    }
}
