package com.example.fleetmanagementsystem.FirebaseServices;

import com.example.fleetmanagementsystem.Constants.FireStoreCollectionsConstants;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;
import com.google.firebase.firestore.FirebaseFirestore;

public class EditDataInFireStore {
    public static void editFleet(FleetModel fleetModel)
    {
        FirebaseFirestore.getInstance()
                .collection(FireStoreCollectionsConstants.FLEET_PATH)
                .document(fleetModel.getCarID())
                .set(fleetModel);
    }
    public static void editDriver(DriverModel driverModel)
    {
        FirebaseFirestore.getInstance()
                .collection(FireStoreCollectionsConstants.DRIVER_PATH)
                .document(driverModel.getDriverId())
                .set(driverModel);
    }
}
