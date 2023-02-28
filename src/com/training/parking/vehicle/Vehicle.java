package com.training.parking.vehicle;

public abstract class Vehicle {

    public abstract VehicleType getVehicleType();

    @Override
    public String toString() {
        return getVehicleType().toString();
    }
}
