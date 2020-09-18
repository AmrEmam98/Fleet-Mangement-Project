package com.example.fleetmanagementsystem.Constants;

import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;

public class FireStoreCollectionsConstants {
    public static String DRIVER_BUSES = "Driver_Buses";
    public static String DRIVER_CARS = "Driver_Cars";
    public static String DRIVERS_TRUCKS = "Driver_Trucks";
    public static String DRIVER_IDLE = "Driver_Idle";
    /////////////////////////////////////////////
    public static String FLEET_CARS = "Fleet_Cars";
    public static String FLEET_BUSES = "Fleet_Buses";
    public static String FLEET_TRUCKS = "Fleet_Trucks";
    public static String FLEET_SPARE = "Fleet_Spare";

    ////////////////////////////////////////////////
    public static String getFleetCollectionType(FleetModel fleetModel) {
        if (fleetModel.getAssignedDriverId() == null) {
            return FLEET_SPARE;
        } else {
            switch (fleetModel.type) {
                case "Car":
                    return FLEET_CARS;
                case "Truck":
                    return FLEET_TRUCKS;
                case "Bus":
                    return FLEET_BUSES;
                default:
                    return FLEET_SPARE;
            }
        }
    }

    public static String getDriverCollectionType(DriverModel driverModel) {
        if (driverModel.getAssignedCarId() == null) {
            return DRIVER_IDLE;
        } else {
            switch (driverModel.getType()) {
                case "Car":
                    return DRIVER_CARS;
                case "Truck":
                    return DRIVERS_TRUCKS;
                case "Bus":
                    return DRIVER_BUSES;
                default:
                    return DRIVER_IDLE;
            }
        }
    }


}
