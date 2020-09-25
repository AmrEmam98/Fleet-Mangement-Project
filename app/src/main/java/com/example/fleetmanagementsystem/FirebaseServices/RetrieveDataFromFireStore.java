package com.example.fleetmanagementsystem.FirebaseServices;

import com.example.fleetmanagementsystem.Constants.FireStoreCollectionsConstants;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.subjects.BehaviorSubject;


public class RetrieveDataFromFireStore {

    public static BehaviorSubject<List<FleetModel>> carsSubject = BehaviorSubject.create();
    public static BehaviorSubject<List<DriverModel>> driverSubject = BehaviorSubject.create();


    public static BehaviorSubject<FleetModel> singleCarSubject = BehaviorSubject.create();
    public static BehaviorSubject<DriverModel> singleDriverSubject = BehaviorSubject.create();
    public static boolean retrieveCarsCalled = false;
    public static boolean retrieveDriversCalled = false;

    public static void retrieveAllCars() {
        FirebaseFirestore.getInstance().collection("Cars")
                .addSnapshotListener((value, error) -> {
                            List<DocumentSnapshot> documents = value.getDocuments();
                            List<FleetModel> fleetModels = new ArrayList<>();
                            for (DocumentSnapshot documentSnapshot : documents) {
                                fleetModels.add(documentSnapshot.toObject(FleetModel.class));
                            }
                            carsSubject.onNext(fleetModels);


                            retrieveCarsCalled = true;

                        }
                );
    }


    public static void retrieveAllDrivers() {
        FirebaseFirestore.getInstance().collection("Drivers")
                .addSnapshotListener((value, error) -> {
                    List<DocumentSnapshot> documents = value.getDocuments();
                    List<DriverModel> driverModels = new ArrayList<>();
                    for (DocumentSnapshot documentSnapshot : documents) {
                        driverModels.add(documentSnapshot.toObject(DriverModel.class));
                    }
                    driverSubject.onNext(driverModels);

                    retrieveDriversCalled = true;
                });

    }

    public static void retrieveFleetByID(String fleetId) {
        FirebaseFirestore.getInstance()
                .collection(FireStoreCollectionsConstants.FLEET_PATH)
                .document(fleetId)
                .get()
                .addOnCompleteListener(task -> {
                            singleCarSubject.onNext(Objects.requireNonNull(task.getResult().toObject(FleetModel.class)));
                        }
                );
    }

    public static void retrieveDriverByID(String driverID) {
        FirebaseFirestore.getInstance()
                .collection(FireStoreCollectionsConstants.DRIVER_PATH)
                .document(driverID)
                .get()
                .addOnCompleteListener(task -> {
                            singleDriverSubject.onNext((task.getResult().toObject(DriverModel.class)));
                        }
                );
    }

}
