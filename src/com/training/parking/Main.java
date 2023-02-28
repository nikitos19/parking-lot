package com.training.parking;

import com.training.parking.vehicle.Car;
import com.training.parking.vehicle.Motorcycle;
import com.training.parking.vehicle.Truck;

public class Main {
    public static void main(String[] args) {
        ParkingLot parking = new ParkingLot(1, 2, 1);
        System.out.println(parking);

        System.out.println(parking.park(new Car())); // true
        System.out.println(parking.park(new Motorcycle())); // true
        System.out.println(parking.park(new Truck())); // true
        System.out.println(parking.park(new Truck())); // false
        Car car2 = new Car();
        System.out.println(parking.park(car2)); // true
        System.out.println(parking.park(new Car())); // false
        parking.unpark(car2);
        System.out.println(parking.park(new Motorcycle())); // true
        System.out.println(parking);
    }
}
