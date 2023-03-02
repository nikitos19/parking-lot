package com.training.parking.branch2.vehicle;

import com.training.parking.branch2.spot.SpotType;

public class Car extends Vehicle {

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.CAR;
    }

    @Override
    public SpotType getSuitableSpotType() {
        return SpotType.COMPACT;
    }
}
