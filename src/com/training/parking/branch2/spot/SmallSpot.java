package com.training.parking.branch2.spot;

import com.training.parking.branch2.vehicle.Vehicle;
import com.training.parking.branch2.vehicle.VehicleType;

public class SmallSpot extends Spot {

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return VehicleType.MOTORCYCLE == vehicle.getVehicleType();
    }

    @Override
    public SpotType getSpotType() {
        return SpotType.SMALL;
    }

    @Override
    protected double getHourlyRate() {
        return 1.0;
    }
}
