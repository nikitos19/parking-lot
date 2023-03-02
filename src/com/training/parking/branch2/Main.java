package com.training.parking.branch2;

import com.training.parking.branch2.vehicle.Car;
import com.training.parking.branch2.vehicle.Motorcycle;
import com.training.parking.branch2.vehicle.Truck;

public class Main {
    public static void main(String[] args) {
//        ParkingLot_PriorityQueue parking = new ParkingLot_PriorityQueue(1, 2, 1);
        ParkingLot_SpotTypeToSpots parking = new ParkingLot_SpotTypeToSpots(1, 2, 1);
        Car car1 = new Car();
        Motorcycle moto1 = new Motorcycle();
        Motorcycle moto2 = new Motorcycle();
        Motorcycle moto3 = new Motorcycle();
        Motorcycle moto4 = new Motorcycle();
        Car car2 = new Car();
        Car car3 = new Car();
        Truck truck1 = new Truck();

        System.out.println(parking);
        System.out.println(parking.park(car1)); // true
        System.out.println(parking.park(moto1)); // true
        System.out.println(parking.park(car2)); // true
        System.out.println(parking.park(truck1)); // true
        System.out.println(parking.park(moto2)); // false
        System.out.println(parking.unpark(truck1)); // true
        System.out.println(parking.park(moto2)); // true
        System.out.println(parking.park(car3)); // true
        System.out.println(parking.unpark(car3)); // true
        System.out.println(parking.park(moto3)); // true
        System.out.println(parking.park(moto4)); // true
        System.out.println(parking);
    }
}
