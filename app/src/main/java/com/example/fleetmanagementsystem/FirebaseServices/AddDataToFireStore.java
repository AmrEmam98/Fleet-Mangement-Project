package com.example.fleetmanagementsystem.FirebaseServices;

import com.example.fleetmanagementsystem.Constants.ObserverStringResponse;
import com.example.fleetmanagementsystem.carsFunctionality.pojo.CarModel;
import com.example.fleetmanagementsystem.driverFunctionality.DriverModel;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.subjects.BehaviorSubject;

public class AddDataToFireStore {
    public static BehaviorSubject<String> addCarSubject = BehaviorSubject.create();
    public static BehaviorSubject<String> addDriverSubject = BehaviorSubject.create();

    public void addCar(CarModel carModel) {
        Map<String, Object> car = new HashMap<>();
        car.put("name", carModel.getName());
        car.put("model", carModel.model2);
        car.put("image", carModel.imageUrl);
        FirebaseFirestore.getInstance()
                .collection("Cars").
                document("Car3")
                .set(car).
                addOnSuccessListener(aVoid -> {
                    addCarSubject.onNext(ObserverStringResponse.SUCCESS_RESPONSE);
                }).addOnFailureListener(e -> {
                    addCarSubject.onNext(ObserverStringResponse.FAIL_RESPONSE);
                }
        );
    }

    public void addDriver(DriverModel driverModel) {
        Map<String, Object> car = new HashMap<>();
        car.put("name", driverModel.getName());
        car.put("id", driverModel.getId());
        car.put("phone", driverModel.getPhone());
        FirebaseFirestore.getInstance()
                .collection("Drivers").
                document(driverModel.getId())
                .set(car).
                addOnSuccessListener(aVoid -> {
                    addDriverSubject.onNext(ObserverStringResponse.SUCCESS_RESPONSE);
                }).addOnFailureListener(e -> {
                    addDriverSubject.onNext(ObserverStringResponse.FAIL_RESPONSE);
                }
        );
    }
}
