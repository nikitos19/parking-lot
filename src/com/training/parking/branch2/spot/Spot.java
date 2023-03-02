package com.training.parking.branch2.spot;

import com.training.parking.branch2.vehicle.Vehicle;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

public abstract class Spot {
    private final Set<Vehicle> vehicles;
    private final double hourRate;
    private double capacity;

    protected Spot(double hourRate, double size) {
        this.hourRate = hourRate;
        this.capacity = size;
        this.vehicles = new HashSet<>();
    }

    public void occupy(Vehicle vehicle) {
        vehicles.add(vehicle);
        vehicle.startParking();
        capacity -= vehicle.getSize();
    }

    public void freeUp(Vehicle vehicle) {
        vehicles.remove(vehicle);
        vehicle.endParking();
        capacity += vehicle.getSize();
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getSize() <= capacity;
    }

    public boolean isFull() {
        return capacity == 0.0;
    }

    public double charge(Vehicle vehicle) {
        return Duration.between(vehicle.getParkedTime(), vehicle.getEndParkingTime()).toMinutes() / 60.0 * hourRate;
    }

    public abstract SpotType getSpotType();

    // other methods

    @Override
    public String toString() {
        return getSpotType().name().toLowerCase() + " spot{" +
            "vehicles=" + vehicles +
            ", capacity=" + capacity +
            '}';
    }
}
