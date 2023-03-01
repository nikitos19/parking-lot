package com.training.parking;

import com.training.parking.spot.CompactSpot;
import com.training.parking.spot.LargeSpot;
import com.training.parking.spot.SmallSpot;
import com.training.parking.spot.Spot;
import com.training.parking.spot.SpotType;
import com.training.parking.vehicle.Vehicle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * The parking lot with Map of spot types to available spots
 * <p>
 * The time complexity should be O(k) where k - spot types number
 */
public class ParkingLot_SpotTypeToSpots {
    private final Map<SpotType, Queue<Spot>> spotTypeToSpots;
    private final Map<Vehicle, Spot> takenSpots;

    public ParkingLot_SpotTypeToSpots(int numOfSmallSpots, int numOfCompactSpots, int numOfLargeSpots) {
        spotTypeToSpots = new HashMap<>();
        spotTypeToSpots.put(SpotType.SMALL, new LinkedList<>());
        spotTypeToSpots.put(SpotType.COMPACT, new LinkedList<>());
        spotTypeToSpots.put(SpotType.LARGE, new LinkedList<>());
        takenSpots = new HashMap<>();

        for (int i = 0; i < numOfSmallSpots; i++) {
            spotTypeToSpots.get(SpotType.SMALL).add(new SmallSpot());
        }
        for (int i = 0; i < numOfCompactSpots; i++) {
            spotTypeToSpots.get(SpotType.COMPACT).add(new CompactSpot());
        }
        for (int i = 0; i < numOfLargeSpots; i++) {
            spotTypeToSpots.get(SpotType.LARGE).add(new LargeSpot());
        }
    }

    public boolean park(Vehicle vehicle) {
        Queue<Spot> availableSpots = spotTypeToSpots.get(vehicle.getSuitableSpotType());
        if (!availableSpots.isEmpty()) {
            return park(vehicle, availableSpots);
        }
        for (Map.Entry<SpotType, Queue<Spot>> spotTypeToAvailableSpots : spotTypeToSpots.entrySet()) {
            if (spotTypeToAvailableSpots.getKey().ordinal() < vehicle.getSuitableSpotType().ordinal()
                || spotTypeToAvailableSpots.getValue().isEmpty()) {
                continue;
            }
            return park(vehicle, spotTypeToAvailableSpots.getValue());
        }
        return false;
    }

    private boolean park(Vehicle vehicle, Queue<Spot> availableSpots) {
        Spot spot = availableSpots.poll();
        spot.occupy(vehicle);
        takenSpots.put(vehicle, spot);
        return true;
    }

    public boolean unpark(Vehicle vehicle) {
        Spot spot = takenSpots.get(vehicle);
        if (spot == null) {
            return false;
        }
        spot.freeUp();
        spotTypeToSpots.get(spot.getSpotType()).add(spot);
        return true;
    }

    @Override
    public String toString() {
        return "ParkingLot{\n" +
            "spot type to available spots: " + spotTypeToSpots +
            "\ntakenSpots=" + takenSpots +
            "\n}";
    }
}
