package com.example.fleetmanagementsystem.driverFunctionality;

import com.google.firebase.firestore.DocumentSnapshot;

public class DriverModel {
    String name;
    String id;
    String phone;
    public  DriverModel(DocumentSnapshot documentSnapshot)
    {
        this.name=documentSnapshot.get("name").toString();
        this.id=documentSnapshot.get("id").toString();
        this.phone=documentSnapshot.get("phone").toString();

    }
    public DriverModel( String id,String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        phone = phone;
    }
}
