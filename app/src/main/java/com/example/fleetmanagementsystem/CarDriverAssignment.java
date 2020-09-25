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
    public static void  unAssignDriver(DriverModel driverModel){

      driverModel.setAssignedCarId(null);
      EditDataInFireStore.editDriver(driverModel);
    }
    public static void  unAssignCar(FleetModel fleetModel){

        fleetModel.setAssignedDriverId(null);
        EditDataInFireStore.editFleet(fleetModel);
    }
    public static void  changeCarDriver(FleetModel fleetModel,DriverModel driverModel){
        fleetModel.setAssignedDriverId(null);
        EditDataInFireStore.editFleet(fleetModel);
    }

}
