package com.example.fleetmanagementsystem.FirebaseServices;

import android.util.Log;

import com.example.fleetmanagementsystem.carsFunctionality.pojo.CarModel;
import com.example.fleetmanagementsystem.driverFunctionality.DriverModel;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import io.reactivex.subjects.BehaviorSubject;

public class RetrieveDataFromFireStore {
    public static BehaviorSubject<List<CarModel>> carsSubject = BehaviorSubject.create();
    public static BehaviorSubject<List<DriverModel>> driverSubject = BehaviorSubject.create();

    public void retrieveAllCars() {
        FirebaseFirestore.getInstance().collection("Cars")
                .get()
                .addOnCompleteListener(task -> {
                    List<CarModel> carModels = task.getResult().toObjects(CarModel.class);
                    carsSubject.onNext(carModels);
                }).addOnFailureListener(e -> {
                    Log.e("FIRE_STORE_ERROR", "ERROR HAPPENED");
                }
        );
    }

    public void retrieveAllDrivers() {
        FirebaseFirestore.getInstance().collection("Drivers")
                .get()
                .addOnCompleteListener(task -> {
                    List<DriverModel> driverModels = task.getResult().toObjects(DriverModel.class);
                    driverSubject.onNext(driverModels);
                }).addOnFailureListener(e -> {
                    Log.e("FIRE_STORE_ERROR", "ERROR HAPPENED");
                }
        );

    }

}
