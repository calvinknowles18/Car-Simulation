package org.coursera.lab.capstone;

public class JapanFactory implements CarFactory {

    @Override
    public Sedan createSedan() {
        return new JapanSedan();
    }

    @Override
    public Coupe createCoupe() {
        return new JapanCoupe();
    }

    @Override
    public Convertible createConvertible() {
        return new JapanConvertible();
    }
}