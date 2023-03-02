package com.training.parking.branch1;

public class Motorcycle extends Vehicle {

    public Motorcycle(String number) {
        super(number);
    }

    @Override
    protected double getSize() {
        return 0.5;
    }
}
