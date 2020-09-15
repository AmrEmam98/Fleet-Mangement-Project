package com.example.fleetmanagementsystem.FirebaseServices;

import android.util.Log;

import com.example.fleetmanagementsystem.carsFunctionality.pojo.CarModel;
import com.example.fleetmanagementsystem.driverFunctionality.DriverModel;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.subjects.BehaviorSubject;

public class RetrieveDataFromFireStore {
    public static BehaviorSubject<List<CarModel>> carsSubject = BehaviorSubject.create();
    public static BehaviorSubject<List<DriverModel>> driverSubject = BehaviorSubject.create();

    public void retrieveAllCars() {
        List<CarModel> carModels = new ArrayList<>();
        FirebaseFirestore.getInstance().collection("Cars")
                .get()
                .addOnCompleteListener(task -> {
                    List<DocumentSnapshot> listOfDocuments = task.getResult().getDocuments();
                    mapDocumentToCar(carModels, listOfDocuments);
                    carsSubject.onNext(carModels);
                }).addOnFailureListener(e -> {
                    Log.e("FIRE_STORE_ERROR", "ERROR HAPPENED");
                }
        );

    }

    public void retrieveAllDrivers() {
        List<DriverModel> driverModels = new ArrayList<>();
        FirebaseFirestore.getInstance().collection("Drivers")
                .get()
                .addOnCompleteListener(task -> {
                    List<DocumentSnapshot> listOfDocuments = task.getResult().getDocuments();
                    mapDocumentToDriver(driverModels, listOfDocuments);
                    driverSubject.onNext(driverModels);
                }).addOnFailureListener(e -> {
                    Log.e("FIRE_STORE_ERROR", "ERROR HAPPENED");
                }
        );

    }

    private void mapDocumentToCar(List<CarModel> carModels, List<DocumentSnapshot> listOfDocuments) {
        for (int i = 0; i < listOfDocuments.size(); i++) {
            CarModel carModel = new CarModel(listOfDocuments.get(i));
            carModels.add(carModel);
        }
    }

    private void mapDocumentToDriver(List<DriverModel> driverModels, List<DocumentSnapshot> listOfDocuments) {
        for (int i = 0; i < listOfDocuments.size(); i++) {
            DriverModel driverModel = new DriverModel(listOfDocuments.get(i));
            driverModels.add(driverModel);
        }
    }

}
