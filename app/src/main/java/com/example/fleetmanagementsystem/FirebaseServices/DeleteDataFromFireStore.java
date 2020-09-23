package com.example.fleetmanagementsystem.FirebaseServices;

import com.example.fleetmanagementsystem.Constants.FireStoreCollectionsConstants;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;
import com.google.firebase.firestore.FirebaseFirestore;

import io.reactivex.subjects.ReplaySubject;

public class DeleteDataFromFireStore {
    public static ReplaySubject<FleetModel> fleetDeletedSubject=ReplaySubject.create();
    public static ReplaySubject<DriverModel> driverDeletedSubject=ReplaySubject.create();

    public static void deleteFleet(FleetModel fleetModel)
    {
        FirebaseFirestore.getInstance()
                .collection(FireStoreCollectionsConstants.FLEET_PATH)
                .document(fleetModel.getCarID())
                .delete().addOnSuccessListener(task->{
                 fleetDeletedSubject.onNext(fleetModel);
        });
    }
    public static void deleteDriver(DriverModel driverModel)
    {
        FirebaseFirestore.getInstance()
                .collection(FireStoreCollectionsConstants.DRIVER_PATH)
                .document(driverModel.getDriverId())
                .delete().addOnSuccessListener(task->{
            driverDeletedSubject.onNext(driverModel);

        });
    }
}
