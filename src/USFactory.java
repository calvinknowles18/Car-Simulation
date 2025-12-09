package org.coursera.lab.capstone;

public class USFactory implements CarFactory {

    @Override
    public Sedan createSedan() {
        return new USSedan();
    }

    @Override
    public Coupe createCoupe() {
        return new USCoupe();
    }

    @Override
    public Convertible createConvertible() {
        return new USConvertible();
    }
}