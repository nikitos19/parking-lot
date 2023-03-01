package com.training.parking;

import com.training.parking.spot.CompactSpot;
import com.training.parking.spot.LargeSpot;
import com.training.parking.spot.SmallSpot;
import com.training.parking.spot.Spot;
import com.training.parking.vehicle.Vehicle;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * The parking lot with a priority queue for available spots
 * <p>
 * The downside is the time complexity could be O(n) in the worse scenario
 * e.g. as the LARGE spot type is the end of queue, and we don't have available spots for the TRUCK,
 * we'll iterate over a whole queue to end up with the false result
 */
public class ParkingLot_PriorityQueue {
    private final Queue<Spot> availableSpots;
    private final Map<Vehicle, Spot> takenSpots = new HashMap<>();

    public ParkingLot_PriorityQueue(int smallSpotsNumber, int compactSpotsNumber, int largeSpotsNumber) {
        availableSpots = new PriorityQueue<>(smallSpotsNumber + compactSpotsNumber + largeSpotsNumber,
            Comparator.comparing(Spot::getSpotType));
        for (int i = 0; i < smallSpotsNumber; i++) {
            availableSpots.add(new SmallSpot());
        }
        for (int i = 0; i < compactSpotsNumber; i++) {
            availableSpots.add(new CompactSpot());
        }
        for (int i = 0; i < largeSpotsNumber; i++) {
            availableSpots.add(new LargeSpot());
        }
    }

    public boolean park(Vehicle vehicle) {
        Iterator<Spot> spotIterator = availableSpots.iterator();
        while (spotIterator.hasNext()) {
            Spot availableSpot = spotIterator.next();
            if (availableSpot.canFitVehicle(vehicle)) {
                availableSpot.occupy(vehicle);
                takenSpots.put(vehicle, availableSpot);
                spotIterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean unpark(Vehicle vehicle) {
        Spot spot = takenSpots.get(vehicle);
        if (spot == null) {
            return false;
        }
        spot.freeUp();
        availableSpots.add(spot);
        return true;
    }

    @Override
    public String toString() {
        return "ParkingLot{\n" +
            "availableSpots = " + availableSpots +
            "\ntakenSpots = " + takenSpots +
            "\n}";
    }
}
