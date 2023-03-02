package com.training.parking.branch2.spot;

import com.training.parking.branch2.vehicle.Vehicle;
import com.training.parking.branch2.vehicle.VehicleType;

public class CompactSpot extends Spot {

    public CompactSpot() {
        super(7.5, 1.0);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return VehicleType.MOTORCYCLE == vehicle.getVehicleType() ||
            VehicleType.CAR == vehicle.getVehicleType();
    }

    @Override
    public SpotType getSpotType() {
        return SpotType.COMPACT;
    }
}
