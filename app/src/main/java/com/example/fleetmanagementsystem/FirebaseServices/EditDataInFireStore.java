package com.example.fleetmanagementsystem.FirebaseServices;

import com.example.fleetmanagementsystem.Constants.FireStoreCollectionsConstants;
import com.example.fleetmanagementsystem.Constants.ObserverStringResponse;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;
import com.google.firebase.firestore.FirebaseFirestore;

import io.reactivex.subjects.PublishSubject;

public class EditDataInFireStore {
    public static PublishSubject<String> fleetEditedSubject=PublishSubject.create();
    public static PublishSubject<String> driverEditedSubject=PublishSubject.create();
    public static void editFleet(FleetModel fleetModel)
    {
        FirebaseFirestore.getInstance()
                .collection(FireStoreCollectionsConstants.FLEET_PATH)
                .document(fleetModel.getCarID())
                .set(fleetModel);
        fleetEditedSubject.onNext(ObserverStringResponse.SUCCESS_RESPONSE);
    }
    public static void editDriver(DriverModel driverModel)
    {
        FirebaseFirestore.getInstance()
                .collection(FireStoreCollectionsConstants.DRIVER_PATH)
                .document(driverModel.getDriverId())
                .set(driverModel);
        driverEditedSubject.onNext(ObserverStringResponse.SUCCESS_RESPONSE);

    }
}
