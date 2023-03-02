package com.training.parking.branch2.spot;

import com.training.parking.branch2.vehicle.Vehicle;

public class LargeSpot extends Spot {

    public LargeSpot() {
        super(10.0, 1.5);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return true;
    }

    @Override
    public SpotType getSpotType() {
        return SpotType.LARGE;
    }
}
