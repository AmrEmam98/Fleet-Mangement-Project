package com.example.fleetmanagementsystem.FirebaseServices;

import android.util.Log;

import com.example.fleetmanagementsystem.Constants.FireStoreCollectionsConstants;
import com.example.fleetmanagementsystem.Constants.ObserverStringResponse;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.subjects.ReplaySubject;

public class RetrieveDataFromFireStore {

    public static ReplaySubject<List<FleetModel>> carsSubject = ReplaySubject.create();
    public static ReplaySubject<List<DriverModel>> driverSubject = ReplaySubject.create();
    public static ReplaySubject<String> completeSubject = ReplaySubject.create();
    public static List<FleetModel> fleetModels=new ArrayList<>();

    public static void retrieveAllCars() {
        FirebaseFirestore.getInstance().collection("Cars")
                .get()
                .addOnCompleteListener(task -> {
                     fleetModels = task.getResult().toObjects(FleetModel.class);
                    carsSubject.onNext(fleetModels);
                }).addOnFailureListener(e -> {
                   completeSubject.onNext(ObserverStringResponse.FAIL_RESPONSE);
                }
        ).addOnCompleteListener(task -> {
            completeSubject.onNext(ObserverStringResponse.SUCCESS_RESPONSE);
        });
    }


    public static void retrieveAllDrivers() {
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
    public static void retrieveDriverCar(DriverModel driverModel){
        FirebaseFirestore.getInstance()
                .collection(FireStoreCollectionsConstants.FLEET_PATH)
                .document(driverModel.getAssignedCarId())
                .get()
                .addOnCompleteListener(task->{
                  List<FleetModel> car= (List<FleetModel>) task.getResult().toObject(FleetModel.class);
                        }
                ).addOnFailureListener(e->{
            completeSubject.onNext(ObserverStringResponse.FAIL_RESPONSE);
        });
    }

}
