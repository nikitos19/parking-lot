package com.training.parking.branch1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Spot {
    private static final double HOUR_RATE = 5.0;
    private final Set<Vehicle> vehicles = new HashSet<>();
    private double capacity = 1.0;

    public boolean canFitVehicle(Vehicle vehicle) {
        return capacity >= vehicle.getSize();
    }

    public boolean isFull() {
        return capacity == 0.0;
    }

    public void occupy(Vehicle vehicle) {
        vehicles.add(vehicle);
        vehicle.setParkedTime(LocalDateTime.now());
        capacity -= vehicle.getSize();
    }

    public void freeUp(Vehicle vehicle) {
        vehicles.remove(vehicle);
        vehicle.setEndParkingTime(LocalDateTime.now());
        capacity += vehicle.getSize();
    }

    public double charge(Vehicle vehicle) {
        return Duration.between(vehicle.getParkedTime(), vehicle.getEndParkingTime())
            .toMinutes() / 60.0 * HOUR_RATE;
    }

    @Override
    public String toString() {
        return "Spot{" +
            "vehicles=" + vehicles +
            ", capacity=" + capacity +
            '}';
    }
}
