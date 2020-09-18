package com.example.fleetmanagementsystem.FirebaseServices;

import com.example.fleetmanagementsystem.Constants.FireStoreCollectionsConstants;
import com.example.fleetmanagementsystem.Constants.ObserverStringResponse;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;
import com.google.firebase.firestore.FirebaseFirestore;

import io.reactivex.subjects.BehaviorSubject;

public class AddDataToFireStore {
    public static BehaviorSubject<String> addCarSubject = BehaviorSubject.create();
    public static BehaviorSubject<String> addDriverSubject = BehaviorSubject.create();

    public static void addCar(FleetModel fleetModel) {
        FirebaseFirestore.getInstance()
                .collection(FireStoreCollectionsConstants.FLEET_PATH)
                .add(fleetModel).
                addOnSuccessListener(aVoid -> {
                    addCarSubject.onNext(ObserverStringResponse.SUCCESS_RESPONSE);
                }).addOnFailureListener(e -> {
                    addCarSubject.onNext(ObserverStringResponse.FAIL_RESPONSE);
                }
        );
    }

    public static void addDriver(DriverModel driverModel) {
        FirebaseFirestore.getInstance()
                .collection(FireStoreCollectionsConstants.DRIVER_PATH)
                .add(driverModel)
               .addOnSuccessListener(aVoid -> {
                    addDriverSubject.onNext(ObserverStringResponse.SUCCESS_RESPONSE);
                }).addOnFailureListener(e -> {
                    addDriverSubject.onNext(ObserverStringResponse.FAIL_RESPONSE);
                }
        );
    }
}
