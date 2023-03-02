package com.training.parking.branch1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ParkingLot {
    private final Set<Spot> spots;
    private final Map<Vehicle, Spot> takenSpots;

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3);
        Car car1 = new Car("AAA");
        Car car2 = new Car("BBB");
        Car car3 = new Car("CCC");
        Car car4 = new Car("DDD");
        Motorcycle moto1 = new Motorcycle("ee");
        Motorcycle moto2 = new Motorcycle("ff");

        System.out.println(parkingLot);
        System.out.println(parkingLot.park(car1));//true
        System.out.println(parkingLot.park(car2));//true
        System.out.println(parkingLot.park(car3));//true
        System.out.println(parkingLot.park(car4));//false
        System.out.println(parkingLot.unpark(car1));//true
        System.out.println(parkingLot.park(moto1));//true
        System.out.println(parkingLot.park(moto2));//true
        System.out.println(parkingLot.unpark(moto1));//true
        System.out.println(parkingLot.unpark(car2));//true
        System.out.println(parkingLot);
    }

    public ParkingLot(int numOfSpots) {
        takenSpots = new HashMap<>();
        spots = new HashSet<>();
        for (int i = 0; i < numOfSpots; i++) {
            spots.add(new Spot());
        }
    }

    public boolean park(Vehicle vehicle) {
        for (Spot spot: spots) {
            if (spot.canFitVehicle(vehicle)) {
                spot.occupy(vehicle);
                takenSpots.put(vehicle, spot);
                if (spot.isFull()) {
                    spots.remove(spot);
                }
                return true;
            }
        }
        return false;
    }

    public boolean unpark(Vehicle vehicle) {
        Spot spot = takenSpots.remove(vehicle);
        if (spot == null) {
            return false;
        }
        spot.freeUp(vehicle);
        spots.add(spot); // Set prevents duplicate
        return true;
    }

    @Override
    public String toString() {
        return "ParkingLot{\n" +
            "available spots = " + spots +
            "\ntaken spots = " + takenSpots +
            "\n}";
    }
}
