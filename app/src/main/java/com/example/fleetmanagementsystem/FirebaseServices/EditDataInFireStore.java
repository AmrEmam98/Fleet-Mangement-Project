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
    public static void editFleet(FleetModel fleetModel,boolean inAssign)
    {
        FirebaseFirestore.getInstance()
                .collection(FireStoreCollectionsConstants.FLEET_PATH)
                .document(fleetModel.getCarID())
                .set(fleetModel);
        if(inAssign){
            if(fleetModel.assignedDriverId==null)
            fleetEditedSubject.onNext(ObserverStringResponse.CAR_UNASSIGNMENT);
            else
                fleetEditedSubject.onNext(ObserverStringResponse.CAR_ASSIGNMENT);


        }
        else {

        fleetEditedSubject.onNext(ObserverStringResponse.SUCCESS_RESPONSE);
        }
    }
    public static void editDriver(DriverModel driverModel,boolean inAssign)
    {
        FirebaseFirestore.getInstance()
                .collection(FireStoreCollectionsConstants.DRIVER_PATH)
                .document(driverModel.getDriverId())
                .set(driverModel);
        if(inAssign){
            if(driverModel.getAssignedCarId()==null)
            driverEditedSubject.onNext(ObserverStringResponse.DRIVER_UNASSIGNMENT);
            else {
                driverEditedSubject.onNext(ObserverStringResponse.DRIVER_ASSIGNMENT);
            }

        }
        else {
            driverEditedSubject.onNext(ObserverStringResponse.SUCCESS_RESPONSE);

        }

    }
}
