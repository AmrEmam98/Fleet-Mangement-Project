package com.example.fleetmanagementsystem.carsFunctionality;

import com.google.firebase.firestore.DocumentId;

public class FleetModel {


    @DocumentId
    public String carID;
    public String name, image,model,assignedDriverId;

    public FleetModel() {
    }

    public FleetModel(String carID, String name, String image, String model, String driverId) {
        this.carID = carID;
        this.name = name;
        this.image = image;
        this.model = model;
        this.assignedDriverId = driverId;
    }

    public String getDriverId() {
        return assignedDriverId;
    }

    public void setDriverId(String driverId) {
        this.assignedDriverId = driverId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
