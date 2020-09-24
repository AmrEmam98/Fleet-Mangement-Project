package com.example.fleetmanagementsystem;

import com.example.fleetmanagementsystem.FirebaseServices.EditDataInFireStore;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;

public class CarDriverAssignment {

    public static void  assign(FleetModel fleetModel, DriverModel driverModel){
        driverModel.setAssignedCarId(fleetModel.carID);
        fleetModel.setAssignedDriverId(driverModel.getDriverId());
        EditDataInFireStore.editDriver(driverModel);
        EditDataInFireStore.editFleet(fleetModel);
    }
}
