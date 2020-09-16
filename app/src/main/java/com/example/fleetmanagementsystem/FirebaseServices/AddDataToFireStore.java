package com.example.fleetmanagementsystem.FirebaseServices;

import com.example.fleetmanagementsystem.Constants.ObserverStringResponse;
import com.example.fleetmanagementsystem.carsFunctionality.FleetModel;
import com.example.fleetmanagementsystem.driverFunctionality.DriverModel;
import com.google.firebase.firestore.FirebaseFirestore;

import io.reactivex.subjects.BehaviorSubject;

public class AddDataToFireStore {
    public static BehaviorSubject<String> addCarSubject = BehaviorSubject.create();
    public static BehaviorSubject<String> addDriverSubject = BehaviorSubject.create();

    public void addCar(FleetModel fleetModel) {
        FirebaseFirestore.getInstance()
                .collection("Cars")
                .add(fleetModel).
                addOnSuccessListener(aVoid -> {
                    addCarSubject.onNext(ObserverStringResponse.SUCCESS_RESPONSE);
                }).addOnFailureListener(e -> {
                    addCarSubject.onNext(ObserverStringResponse.FAIL_RESPONSE);
                }
        );
    }

    public void addDriver(DriverModel driverModel) {
        FirebaseFirestore.getInstance()
                .collection("Drivers")
                .add(driverModel)
               .addOnSuccessListener(aVoid -> {
                    addDriverSubject.onNext(ObserverStringResponse.SUCCESS_RESPONSE);
                }).addOnFailureListener(e -> {
                    addDriverSubject.onNext(ObserverStringResponse.FAIL_RESPONSE);
                }
        );
    }
}
