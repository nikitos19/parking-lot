package com.training.parking.branch2.spot;

import com.training.parking.branch2.vehicle.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Spot {
    private LocalDateTime parkedTime;
    private Vehicle vehicle;

    public void occupy(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.parkedTime = LocalDateTime.now();
    }

    public void freeUp() {
        this.vehicle = null;
        this.parkedTime = null;
    }

    public double charge() {
        if (vehicle == null || parkedTime == null) {
            return 0.0;
        }

        double hours = Duration.between(parkedTime, LocalDateTime.now()).toMinutes() / 60.0;
        return hours * getHourlyRate();
    }

    public abstract boolean canFitVehicle(Vehicle vehicle);

    public abstract SpotType getSpotType();

    protected abstract double getHourlyRate();

    // other methods
    @Override
    public String toString() {
        return getSpotType().name().toLowerCase() + " spot";
    }
}
