package carsim;

public class JapanConvertible extends Convertible {
    // logic to build Convertible
    public JapanConvertible() {
        super();
        this.cost = 20000;
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
        return new JapanSportSuspension();
    }

    @Override
    public Tires buildTires() {
        return new JapanSportTires();
    }
}
