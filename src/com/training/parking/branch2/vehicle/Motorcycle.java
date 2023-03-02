package com.training.parking.branch2.vehicle;

import com.training.parking.branch2.spot.SpotType;

public class Motorcycle extends Vehicle {
    @Override
    public VehicleType getVehicleType() {
        return VehicleType.MOTORCYCLE;
    }

    @Override
    public SpotType getSuitableSpotType() {
        return SpotType.SMALL;
    }
}
