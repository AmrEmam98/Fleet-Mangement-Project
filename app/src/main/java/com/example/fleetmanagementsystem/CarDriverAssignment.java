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
            int lastIndex=fleetModel.carHistoryList.size()-1;
            fleetModel.carHistoryList.get(lastIndex).setEndDate();
            EditDataInFireStore.editFleet(fleetModel);
        }
        );

    }

    public static void unAssign(FleetModel fleetModel,DriverModel driverModel,String dir){

        fleetModel.setAssignedDriverId(null);
        driverModel.setAssignedCarId(null);

        if(dir.equals("Driver")){
            int lastIndex=driverModel.getDriverHistoryModelList().size()-1;
            driverModel.getDriverHistoryModelList().get(lastIndex).setEndDate();
        }
        if(dir.equals("Car")){
            int lastIndex=fleetModel.carHistoryList.size()-1;
            fleetModel.carHistoryList.get(lastIndex).setEndDate();
        }

        EditDataInFireStore.editFleet(fleetModel);
        EditDataInFireStore.editDriver(driverModel);
    }


}
