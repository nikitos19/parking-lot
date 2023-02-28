package com.training.parking.spot;

import com.training.parking.vehicle.VehicleType;

public enum SpotType {
    SMALL {
        @Override
        public boolean canFitVehicle(VehicleType vehicleType) {
            return VehicleType.MOTORCYCLE == vehicleType;
        }
    },
    COMPACT {
        @Override
        public boolean canFitVehicle(VehicleType vehicleType) {
            return VehicleType.MOTORCYCLE == vehicleType || VehicleType.CAR == vehicleType;
        }
    },
    LARGE {
        @Override
        public boolean canFitVehicle(VehicleType vehicleType) {
            return true;
        }
    };

    public abstract boolean canFitVehicle(VehicleType vehicleType);
}
