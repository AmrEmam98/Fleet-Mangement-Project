package com.example.fleetmanagementsystem.carsFunctionality.viewModels;

import androidx.lifecycle.ViewModel;

import com.example.fleetmanagementsystem.FirebaseServices.AddDataToFireStore;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;

public class AddCarViewModel extends ViewModel {
    public void addCar(String carName,String carModel,String plateNum,String chasissNum,String color,String vehicleType){
       FleetModel car=new FleetModel(
               carName,
               carModel,
               plateNum,
               chasissNum,
               color,
               vehicleType
       );
      AddDataToFireStore.addCar(car);
    }

}
