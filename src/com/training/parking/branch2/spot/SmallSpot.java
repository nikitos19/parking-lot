package com.training.parking.branch2.spot;

import com.training.parking.branch2.vehicle.Vehicle;
import com.training.parking.branch2.vehicle.VehicleType;

public class SmallSpot extends Spot {

    public SmallSpot() {
        super(5.0, 0.5);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return VehicleType.MOTORCYCLE == vehicle.getVehicleType();
    }

    @Override
    public SpotType getSpotType() {
        return SpotType.SMALL;
    }
}
