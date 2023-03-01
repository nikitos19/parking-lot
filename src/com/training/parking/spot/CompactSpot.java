package com.training.parking.spot;

import com.training.parking.vehicle.Vehicle;
import com.training.parking.vehicle.VehicleType;

public class CompactSpot extends Spot {

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return VehicleType.MOTORCYCLE == vehicle.getVehicleType() ||
            VehicleType.CAR == vehicle.getVehicleType();
    }

    @Override
    public SpotType getSpotType() {
        return SpotType.COMPACT;
    }

    @Override
    protected double getHourlyRate() {
        return 2.0;
    }
}
