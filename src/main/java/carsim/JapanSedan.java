package carsim;

public class JapanSedan extends Sedan {
    // logic to build Sedan
    public JapanSedan() {
        super();
        this.cost = 10000;
        assembleComponents();
    }

    public void assembleComponents() {
        this.engine = buildEngine();
        this.suspension = buildSuspension();
        this.tires = buildTires();
    }

    @Override
    public Engine buildEngine() {
        return new JapanEconomyEngine();
    }

    @Override
    public Suspension buildSuspension() {
        return new JapanEconomySuspension();
    }

    @Override
    public Tires buildTires() {
        return new JapanEconomyTires();
    }
}
