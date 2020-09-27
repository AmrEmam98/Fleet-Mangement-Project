package com.example.fleetmanagementsystem.driverFunctionality.models;

import com.google.firebase.firestore.DocumentId;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DriverModel implements Serializable {

    @DocumentId
    String driverId;
    String assignedCarId;
    String name;
    String phone;
    String type;

    List <DriverHistoryModel> driverHistoryModelList = new ArrayList<>();

    public DriverModel() {

    }

    public DriverModel(String name, String phone, String type) {
        this.name = name;
        this.phone = phone;
        this.type=type;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }


    public String getAssignedCarId() {
        return assignedCarId;
    }

    public void setAssignedCarId(String assignedCarId) {
        this.assignedCarId = assignedCarId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<DriverHistoryModel> getDriverHistoryModelList() {
        return driverHistoryModelList;
    }

    public void setDriverHistoryModelList(List<DriverHistoryModel> driverHistoryModelList) {
        this.driverHistoryModelList = driverHistoryModelList;
    }
}
