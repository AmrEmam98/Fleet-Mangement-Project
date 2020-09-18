package com.example.fleetmanagementsystem.driverFunctionality.viewModels;

import androidx.lifecycle.ViewModel;

import com.example.fleetmanagementsystem.Constants.FireStoreCollectionsConstants;
import com.example.fleetmanagementsystem.FirebaseServices.AddDataToFireStore;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;

public class AddDriverViewModel extends ViewModel {
    public void doAddDriver(String driverName,String phoneNumber,String type){
        DriverModel driverModel=new DriverModel(driverName,phoneNumber,type);
        new AddDataToFireStore().addDriver(driverModel, FireStoreCollectionsConstants.DRIVER_IDLE);
    }

}
