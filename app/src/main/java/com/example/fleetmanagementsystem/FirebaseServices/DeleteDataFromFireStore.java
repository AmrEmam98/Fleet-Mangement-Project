package com.example.fleetmanagementsystem.FirebaseServices;

import com.example.fleetmanagementsystem.Constants.FireStoreCollectionsConstants;
import com.example.fleetmanagementsystem.Constants.ObserverStringResponse;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;
import com.google.firebase.firestore.FirebaseFirestore;

import io.reactivex.subjects.PublishSubject;

public class DeleteDataFromFireStore {
    public static PublishSubject<String> fleetDeletedSubject=PublishSubject.create();
    public static PublishSubject<String> driverDeletedSubject=PublishSubject.create();

    public static void deleteFleet(FleetModel fleetModel)
    {
        FirebaseFirestore.getInstance()
                .collection(FireStoreCollectionsConstants.FLEET_PATH)
                .document(fleetModel.getCarID())
                .delete().addOnCompleteListener(task->{
                 fleetDeletedSubject.onNext(ObserverStringResponse.SUCCESS_RESPONSE);
        });
    }
    public static void deleteDriver(DriverModel driverModel)
    {
        FirebaseFirestore.getInstance()
                .collection(FireStoreCollectionsConstants.DRIVER_PATH)
                .document(driverModel.getDriverId())
                .delete().addOnCompleteListener(task->{
            driverDeletedSubject.onNext(ObserverStringResponse.SUCCESS_RESPONSE);

        });
    }
}
