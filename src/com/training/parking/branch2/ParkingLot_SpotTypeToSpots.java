package com.training.parking.branch2;

import com.training.parking.branch2.spot.CompactSpot;
import com.training.parking.branch2.spot.LargeSpot;
import com.training.parking.branch2.spot.SmallSpot;
import com.training.parking.branch2.spot.Spot;
import com.training.parking.branch2.spot.SpotType;
import com.training.parking.branch2.vehicle.Vehicle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * The parking lot with Map of spot types to available spots
 */
public class ParkingLot_SpotTypeToSpots {
    private final Map<SpotType, Set<Spot>> spotTypeToSpots;
    private final Map<Vehicle, Spot> takenSpots;

    public ParkingLot_SpotTypeToSpots(int numOfSmallSpots, int numOfCompactSpots, int numOfLargeSpots) {
        spotTypeToSpots = new HashMap<>();
        spotTypeToSpots.put(SpotType.SMALL, new HashSet<>());
        spotTypeToSpots.put(SpotType.COMPACT, new HashSet<>());
        spotTypeToSpots.put(SpotType.LARGE, new HashSet<>());
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
        if (park(vehicle, spotTypeToSpots.get(vehicle.getSuitableSpotType()).iterator())) {
            return true;
        }

        for (Map.Entry<SpotType, Set<Spot>> spotTypeToAvailableSpots : spotTypeToSpots.entrySet()) {
            if (spotTypeToAvailableSpots.getKey().ordinal() < vehicle.getSuitableSpotType().ordinal()
                || spotTypeToAvailableSpots.getValue().isEmpty()) {
                continue;
            }
            if (park(vehicle, spotTypeToAvailableSpots.getValue().iterator())) {
                return true;
            }
        }
        return false;
    }

    private boolean park(Vehicle vehicle, Iterator<Spot> availableSpots) {
        while (availableSpots.hasNext()) {
            Spot spot = availableSpots.next();
            if (spot.canFitVehicle(vehicle)) {
                spot.occupy(vehicle);
                if (spot.isFull()) {
                    availableSpots.remove();
                }
                takenSpots.put(vehicle, spot);
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
        spot.freeUp(vehicle);
        spotTypeToSpots.get(spot.getSpotType()).add(spot);
        return true;
    }

    @Override
    public String toString() {
        return "ParkingLot{\n" +
            "spot type to available spots: " + spotTypeToSpots +
            "\ntakenSpots=" + takenSpots.values().stream().distinct().toList() +
            "\n}";
    }
}
