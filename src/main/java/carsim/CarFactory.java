package carsim;

public interface CarFactory {
    Sedan createSedan();
    Coupe createCoupe();
    Convertible createConvertible();
}