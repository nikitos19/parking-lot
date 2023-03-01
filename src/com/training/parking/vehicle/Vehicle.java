package com.training.parking.vehicle;

import com.training.parking.spot.SpotType;

public abstract class Vehicle {

    public abstract VehicleType getVehicleType();

    public abstract SpotType getSuitableSpotType();

    @Override
    public String toString() {
        return "vehicle " + getVehicleType().toString().toLowerCase();
    }
}
