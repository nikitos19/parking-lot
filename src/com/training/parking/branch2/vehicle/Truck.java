package com.training.parking.branch2.vehicle;

import com.training.parking.branch2.spot.SpotType;

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
