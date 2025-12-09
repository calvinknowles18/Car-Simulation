package org.coursera.lab.capstone;

public class USCoupe extends Coupe {
    // logic to build Coupe
    public USCoupe() {
        super();
        this.cost = 18000;
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
        return new USRacingSuspension();
    }

    @Override
    public Tires buildTires() {
        return new USRacingTires();
    }
}
