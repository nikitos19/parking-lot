package com.training.parking.branch2.vehicle;

import com.training.parking.branch2.spot.SpotType;

import java.time.LocalDateTime;

public abstract class Vehicle {
    private final double size;
    private LocalDateTime parkedTime;
    private LocalDateTime endParkingTime;

    protected Vehicle(double size) {
        this.size = size;
    }

    public abstract VehicleType getVehicleType();

    public abstract SpotType getSuitableSpotType();

    public double getSize() {
        return this.size;
    }

    public LocalDateTime getParkedTime() {
        return parkedTime;
    }

    public void startParking() {
        this.parkedTime = LocalDateTime.now();
    }

    public LocalDateTime getEndParkingTime() {
        return endParkingTime;
    }

    public void endParking() {
        this.endParkingTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "vehicle " + getVehicleType().toString().toLowerCase();
    }
}
