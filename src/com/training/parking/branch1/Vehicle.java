package com.training.parking.branch1;

import java.time.LocalDateTime;

public abstract class Vehicle {
    private final String number;
    private LocalDateTime parkedTime;
    private LocalDateTime endParkingTime;

    protected Vehicle(String number) {
        this.number = number;
    }

    protected abstract double getSize();

    public LocalDateTime getParkedTime() {
        return parkedTime;
    }

    public void setParkedTime(LocalDateTime parkedTime) {
        this.parkedTime = parkedTime;
    }

    public LocalDateTime getEndParkingTime() {
        return endParkingTime;
    }

    public void setEndParkingTime(LocalDateTime endParkingTime) {
        this.endParkingTime = endParkingTime;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
            "number='" + number + '\'' +
            '}';
    }
}
