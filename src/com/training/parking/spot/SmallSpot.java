package com.training.parking.spot;

import com.training.parking.vehicle.Vehicle;
import com.training.parking.vehicle.VehicleType;

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
