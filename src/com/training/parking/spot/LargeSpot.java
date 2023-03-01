package com.training.parking.spot;

import com.training.parking.vehicle.Vehicle;

public class LargeSpot extends Spot {

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return true;
    }

    @Override
    public SpotType getSpotType() {
        return SpotType.LARGE;
    }

    @Override
    protected double getHourlyRate() {
        return 3.0;
    }
}
