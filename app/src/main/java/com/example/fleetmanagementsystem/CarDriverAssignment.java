package com.example.fleetmanagementsystem;

import android.annotation.SuppressLint;

import com.example.fleetmanagementsystem.FirebaseServices.EditDataInFireStore;
import com.example.fleetmanagementsystem.FirebaseServices.RetrieveDataFromFireStore;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;

public class CarDriverAssignment {

    public static void  assign(FleetModel fleetModel, DriverModel driverModel){
        driverModel.setAssignedCarId(fleetModel.carID);
        fleetModel.setAssignedDriverId(driverModel.getDriverId());
        EditDataInFireStore.editDriver(driverModel);
        EditDataInFireStore.editFleet(fleetModel);
    }
    @SuppressLint("CheckResult")
    public static void  unAssignDriver(String driverID){
        if(driverID==null)
            return;
        RetrieveDataFromFireStore.retrieveDriverByID(driverID);
        RetrieveDataFromFireStore.singleDriverSubject.subscribe(
                driverModel -> {
                    driverModel.setAssignedCarId(null);
                    EditDataInFireStore.editDriver(driverModel);
                }
        );
    }
    @SuppressLint("CheckResult")
    public static void  unAssignCar(String carID){
        if(carID==null)
            return;
        RetrieveDataFromFireStore.retrieveFleetByID(carID);
        RetrieveDataFromFireStore.singleCarSubject.subscribe(
                fleetModel -> {
                    fleetModel.setAssignedDriverId(null);
                    fleetModel.carHistoryList.get(fleetModel.carHistoryList.size()-1).setEndDate();
                    EditDataInFireStore.editFleet(fleetModel);
                }
        );

    }


}
