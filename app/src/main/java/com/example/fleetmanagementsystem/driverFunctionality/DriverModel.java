package com.example.fleetmanagementsystem.driverFunctionality;

import com.google.firebase.firestore.DocumentId;

public class DriverModel {
    @DocumentId
    String driverId;
    String assignedCarId="";
    String name;
    String phone;

    public DriverModel() {

    }

    public DriverModel(String driverId, String assignedCarId, String name, String phone) {
        this.driverId = driverId;
        this.assignedCarId = assignedCarId;
        this.name = name;
        this.phone = phone;
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
        phone = phone;
    }
}
