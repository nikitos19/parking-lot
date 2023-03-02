package com.training.parking.branch2.vehicle;

import com.training.parking.branch2.spot.SpotType;

public abstract class Vehicle {

    public abstract VehicleType getVehicleType();

    public abstract SpotType getSuitableSpotType();

    @Override
    public String toString() {
        return "vehicle " + getVehicleType().toString().toLowerCase();
    }
}
