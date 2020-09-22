package com.example.fleetmanagementsystem.dataFilter;

import android.annotation.SuppressLint;

import com.example.fleetmanagementsystem.FirebaseServices.RetrieveDataFromFireStore;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;

import java.util.ArrayList;
import java.util.List;

public class DriverFilter {

    List<DriverModel> Cars;
    List<DriverModel> Bus;
    List<DriverModel> Truck;
    List<DriverModel> Spare;

    public DriverFilter() {
        Cars = new ArrayList<>();
        Bus = new ArrayList<>();
        Truck = new ArrayList<>();
        Spare = new ArrayList<>();
        filterDriver();
    }

    @SuppressLint("CheckResult")
    public void filterDriver() {
        RetrieveDataFromFireStore.driverSubject.subscribe(driverModels -> {
                    if (driverModels != null)
                        for (int i = 0; i < driverModels.size(); i++) {

                            if (driverModels.get(i).getAssignedCarId() == null)
                                Spare.add(driverModels.get(i));
                            else {
                                if (driverModels.get(i).getType().equals("Car"))
                                    Cars.add(driverModels.get(i));
                                if (driverModels.get(i).getType().equals("Bus"))
                                    Bus.add(driverModels.get(i));
                                if (driverModels.get(i).getType().equals("Truck"))
                                    Truck.add(driverModels.get(i));
                            }

                        }

                }
        );
    }

    public List<DriverModel> getCars() {
        return Cars;
    }

    public List<DriverModel> getBus() {
        return Bus;
    }

    public List<DriverModel> getTruck() {
        return Truck;
    }

    public List<DriverModel> getSpare() {
        return Spare;
    }


}
