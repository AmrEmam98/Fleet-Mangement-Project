package com.example.fleetmanagementsystem.homeFunctionality;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.FleetModel;
import com.example.fleetmanagementsystem.driverFunctionality.DriverModel;

import java.util.List;


public class HomeActivity extends AppCompatActivity {
    List<FleetModel> fleetModels;
    private List<DriverModel> driverModels;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    //  addCarExample();
//        getCars();
//        new RetrieveDataFromFireStore().retrieveAllCars();
//        getDrivers();
    //   addDriverExample();
}

//    @SuppressLint("CheckResult")
//    private void addDriverExample(){
//        DriverModel driverModel= new DriverModel("2","Ahmed","012345679");
//        new AddDataToFireStore().addDriver(driverModel);
//        AddDataToFireStore.addDriverSubject.subscribe(result->{
//            if(result.equals(ObserverStringResponse.SUCCESS_RESPONSE))
//            {
//                Toast.makeText(this,"Driver Added",Toast.LENGTH_LONG).show();
//
//            }else {
//                Toast.makeText(this,"Error Happend",Toast.LENGTH_LONG).show();
//            }
//        });
//
//    }
//    @SuppressLint("CheckResult")
//    private void addCarExample() {
//        AddDataToFireStore.addCarSubject.subscribe(result->{
//            if(result.equals(ObserverStringResponse.SUCCESS_RESPONSE))
//            {
//                Toast.makeText(this,"Car Added",Toast.LENGTH_LONG).show();
//            }else {
//                Toast.makeText(this,"Error Happend",Toast.LENGTH_LONG).show();
//            }
//        });
//        CarModel car=new CarModel();
//        car.name="Kia";
//        car.model="2020";
//        car.image ="kia.com/us/content/dam/kia/us/en/home/vehicle-carousel/forte_2020/kia_forte_2020_home_mobile_vehicle_carousel.png";
//        new  AddDataToFireStore().addCar(car);
////        new RetrieveDataFromFireStore().retrieveAllCars();
//    }
//
//    @SuppressLint("CheckResult")
//   public void getCars(){
//       RetrieveDataFromFireStore.carsSubject.subscribe(carModels -> {
//            this.carModels=carModels;
//        });
//    }
//    @SuppressLint("CheckResult")
//    public void getDrivers(){
//        RetrieveDataFromFireStore.driverSubject.subscribe(driverModels -> {
//            this.driverModels=driverModels;
//        });
//
//    }
}