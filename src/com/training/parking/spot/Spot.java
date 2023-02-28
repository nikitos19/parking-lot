package com.training.parking.spot;

import com.training.parking.vehicle.Vehicle;

public class Spot {
    private SpotType spotType;
    private Vehicle vehicle;

    public Spot(SpotType spotType) {
        this.spotType = spotType;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return spotType.canFitVehicle(vehicle.getVehicleType());
    }

    public void occupy(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void freeUp() {
        this.vehicle = null;
    }

    public SpotType getSpotType() {
        return this.spotType;
    }

    @Override
    public String toString() {
        return spotType + " Spot";
    }
}
