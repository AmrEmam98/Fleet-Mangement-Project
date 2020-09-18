package com.example.fleetmanagementsystem.FirebaseServices;

import android.util.Log;

import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import io.reactivex.subjects.BehaviorSubject;

public class RetrieveDataFromFireStore {

    public static BehaviorSubject<List<FleetModel>> carsSubject = BehaviorSubject.create();
    public static BehaviorSubject<List<FleetModel>> trucksSubject = BehaviorSubject.create();
    public static BehaviorSubject<List<DriverModel>> driverSubject = BehaviorSubject.create();

    public void retrieveAllCars() {
        FirebaseFirestore.getInstance().collection("Cars")
                .get()
                .addOnCompleteListener(task -> {
                    List<FleetModel> fleetModels = task.getResult().toObjects(FleetModel.class);
                    carsSubject.onNext(fleetModels);
                }).addOnFailureListener(e -> {
                    Log.e("FIRE_STORE_ERROR", "ERROR HAPPENED");
                }
        );
    }
    public void retrieveTrucks() {
        FirebaseFirestore.getInstance().collection("Cars").whereEqualTo("type" , "bus")
                .get()
                .addOnCompleteListener(task -> {
                    List<FleetModel> fleetModels = task.getResult().toObjects(FleetModel.class);
                    trucksSubject.onNext(fleetModels);
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
