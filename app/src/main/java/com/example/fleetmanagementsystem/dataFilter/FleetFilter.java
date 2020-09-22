package com.example.fleetmanagementsystem.dataFilter;


import android.annotation.SuppressLint;

import com.example.fleetmanagementsystem.FirebaseServices.RetrieveDataFromFireStore;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;

import java.util.ArrayList;
import java.util.List;

public class FleetFilter {

    List<FleetModel> cars;
    List<FleetModel> buses;
    List<FleetModel> spare;

    public FleetFilter() {
        cars = new ArrayList<>();
        buses = new ArrayList<>();
        spare = new ArrayList<>();
        filterFleet();
    }

    @SuppressLint("CheckResult")
    public void filterFleet() {
        RetrieveDataFromFireStore.carsSubject.subscribe(fleetModels -> {
                    if (fleetModels != null)
                        for (int i = 0; i < fleetModels.size(); i++) {
                            if (fleetModels.get(i).getAssignedDriverId() == null)
                                spare.add(fleetModels.get(i));
                            else {
                                if (fleetModels.get(i).type.equals("Car"))
                                    cars.add(fleetModels.get(i));
                                if (fleetModels.get(i).type.equals("Bus"))
                                    buses.add(fleetModels.get(i));

                            }

                        }

                }
        );
    }

    public List<FleetModel> getCars() {
        return cars;
    }

    public List<FleetModel> getBuses() {
        return buses;
    }

    public List<FleetModel> getSpare() {
        return spare;
    }
}
