package com.example.fleetmanagementsystem.FirebaseServices;

import com.example.fleetmanagementsystem.Constants.ObserverStringResponse;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;
import com.google.firebase.firestore.FirebaseFirestore;

import io.reactivex.subjects.BehaviorSubject;

public class AddDataToFireStore {
    public static BehaviorSubject<String> addCarSubject = BehaviorSubject.create();
    public static BehaviorSubject<String> addDriverSubject = BehaviorSubject.create();

    public void addCar(FleetModel fleetModel,String collectionPath) {
        FirebaseFirestore.getInstance()
                .collection(collectionPath)
                .add(fleetModel).
                addOnSuccessListener(aVoid -> {
                    addCarSubject.onNext(ObserverStringResponse.SUCCESS_RESPONSE);
                }).addOnFailureListener(e -> {
                    addCarSubject.onNext(ObserverStringResponse.FAIL_RESPONSE);
                }
        );
    }

    public void addDriver(DriverModel driverModel,String collectionPath) {
        FirebaseFirestore.getInstance()
                .collection(collectionPath)
                .add(driverModel)
               .addOnSuccessListener(aVoid -> {
                    addDriverSubject.onNext(ObserverStringResponse.SUCCESS_RESPONSE);
                }).addOnFailureListener(e -> {
                    addDriverSubject.onNext(ObserverStringResponse.FAIL_RESPONSE);
                }
        );
    }
}
