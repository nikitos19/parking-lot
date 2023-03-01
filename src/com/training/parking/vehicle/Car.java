package com.training.parking.vehicle;

import com.training.parking.spot.SpotType;

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
