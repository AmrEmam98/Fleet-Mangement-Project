package com.example.fleetmanagementsystem.FirebaseServices;

import com.example.fleetmanagementsystem.Constants.FireStoreCollectionsConstants;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;
import com.google.firebase.firestore.FirebaseFirestore;

public class DeleteDataFromFireStore {
    public void deleteFleet(FleetModel fleetModel)
    {
        FirebaseFirestore.getInstance()
                .collection(FireStoreCollectionsConstants.getFleetCollectionType(fleetModel))
                .document(fleetModel.getCarID())
                .delete();
    }
    public void deleteDriver(DriverModel driverModel)
    {
        FirebaseFirestore.getInstance()
                .collection(FireStoreCollectionsConstants.getDriverCollectionType(driverModel))
                .document(driverModel.getDriverId())
                .delete();
    }
}
