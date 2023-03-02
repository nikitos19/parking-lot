package com.training.parking.branch1;

public class Car extends Vehicle {

    public Car(String number) {
        super(number);
    }

    @Override
    protected double getSize() {
        return 1.0;
    }
}
