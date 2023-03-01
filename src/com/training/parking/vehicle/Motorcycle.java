package com.training.parking.vehicle;

import com.training.parking.spot.SpotType;

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
