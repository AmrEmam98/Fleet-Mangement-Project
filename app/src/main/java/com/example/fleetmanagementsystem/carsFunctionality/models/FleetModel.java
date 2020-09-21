package com.example.fleetmanagementsystem.carsFunctionality.models;

import com.google.firebase.firestore.DocumentId;

import java.io.Serializable;

public class FleetModel implements Serializable {


    @DocumentId
    public String carID;
    public String name,model,assignedDriverId,plateNum,chassisNum,carColor,type;


    public FleetModel() {
    }

    public FleetModel(
    String name, String model, String plateNum, String chassisNum, String carColor, String type) {
        this.name = name;
        this.model = model;
        this.plateNum = plateNum;
        this.chassisNum = chassisNum;
        this.carColor = carColor;
        this.type = type;
    }


    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public String getAssignedDriverId() {
        return assignedDriverId;
    }

    public void setAssignedDriverId(String assignedDriverId) {
        this.assignedDriverId = assignedDriverId;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public String getChassisNum() {
        return chassisNum;
    }

    public void setChassisNum(String chassisNum) {
        this.chassisNum = chassisNum;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
