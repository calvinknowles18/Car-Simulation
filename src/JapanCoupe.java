package org.coursera.lab.capstone;

public class JapanCoupe extends Coupe {
    // logic to build Coupe
    public JapanCoupe() {
        super();
        this.cost = 15000;
        assembleComponents();
    }

    public void assembleComponents() {
        this.engine = buildEngine();
        this.suspension = buildSuspension();
        this.tires = buildTires();
    }

    @Override
    public Engine buildEngine() {
        return new JapanSportEngine();
    }

    @Override
    public Suspension buildSuspension() {
        return new JapanEconomySuspension();
    }

    @Override
    public Tires buildTires() {
        return new JapanSportTires();
    }
}
