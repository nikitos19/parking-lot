package com.training.parking.vehicle;

import com.training.parking.spot.SpotType;

public class Truck extends Vehicle {
    @Override
    public VehicleType getVehicleType() {
        return VehicleType.TRUCK;
    }

    @Override
    public SpotType getSuitableSpotType() {
        return SpotType.LARGE;
    }
}
