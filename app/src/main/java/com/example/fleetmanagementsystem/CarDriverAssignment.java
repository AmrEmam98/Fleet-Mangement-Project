package com.example.fleetmanagementsystem;

import android.annotation.SuppressLint;

import com.example.fleetmanagementsystem.FirebaseServices.EditDataInFireStore;
import com.example.fleetmanagementsystem.FirebaseServices.RetrieveDataFromFireStore;
import com.example.fleetmanagementsystem.carsFunctionality.models.CarHistoryModel;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverHistoryModel;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;

public class CarDriverAssignment {
    @SuppressLint("CheckResult")
    public static void  assign(FleetModel fleetModel, DriverModel driverModel, String dir){
        driverModel.setAssignedCarId(fleetModel.carID);
        fleetModel.setAssignedDriverId(driverModel.getDriverId());
        driverModel.getDriverHistoryModelList().add(new DriverHistoryModel(fleetModel.getCarID(),fleetModel.getName()));
        fleetModel.carHistoryList.add(new CarHistoryModel(driverModel.getDriverId(),driverModel.getName()));
        EditDataInFireStore.editDriver(driverModel,dir.equals("Driver"));
        EditDataInFireStore.editFleet(fleetModel,dir.equals("Car"));

    }
    @SuppressLint("CheckResult")
    public static void  unAssignDriver(String driverID){
        if(driverID==null)
            return;
        RetrieveDataFromFireStore.retrieveDriverByID(driverID);
        RetrieveDataFromFireStore.singleDriverSubject.subscribe(
                driverModel -> {
                    driverModel.setAssignedCarId(null);
                    EditDataInFireStore.editDriver(driverModel,true);
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
            EditDataInFireStore.editFleet(fleetModel,false);
        }
        );

    }

    @SuppressLint("CheckResult")
    public static void unAssign(FleetModel fleetModel, DriverModel driverModel, String dir){

        fleetModel.setAssignedDriverId(null);
        driverModel.setAssignedCarId(null);
        int driverHistoryLastIndex=driverModel.getDriverHistoryModelList().size()-1;
        driverModel.getDriverHistoryModelList().get(driverHistoryLastIndex).setEndDate();
        int carHistoryLastIndex=fleetModel.carHistoryList.size()-1;
        fleetModel.carHistoryList.get(carHistoryLastIndex).setEndDate();
        EditDataInFireStore.editFleet(fleetModel,dir.equals("Car"));
        EditDataInFireStore.editDriver(driverModel,dir.equals("Driver"));


    }


}
