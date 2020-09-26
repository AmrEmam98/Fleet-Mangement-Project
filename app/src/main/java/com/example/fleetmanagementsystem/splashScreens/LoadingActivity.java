package com.example.fleetmanagementsystem.splashScreens;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fleetmanagementsystem.Constants.BundleKeys;
import com.example.fleetmanagementsystem.Constants.ObserverStringResponse;
import com.example.fleetmanagementsystem.FirebaseServices.RetrieveDataFromFireStore;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.activites.FleetActivity;
import com.example.fleetmanagementsystem.driverFunctionality.activities.DriversActivity;

public class LoadingActivity extends AppCompatActivity {
    ProgressBar progressBar;
    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        String type = getIntent().getStringExtra(BundleKeys.ACTIVITY_TYPE);
        carsSubscribe();
        driverSubscribe();
        progressBar=findViewById(R.id.loadingProgressBar);
        if(!RetrieveDataFromFireStore.retrieveDriversCalled)
            RetrieveDataFromFireStore.retrieveAllDrivers();
        if(!RetrieveDataFromFireStore.retrieveCarsCalled)
            RetrieveDataFromFireStore.retrieveAllCars();
        if(type.equals(BundleKeys.CAR_ACTIVITY_TYPE)) {

                openFleetActivity();
        }
        if(type.equals(BundleKeys.DRIVER_ACTIVITY_TYPE)) {
                openDriverActivity();
        }

    }

    @SuppressLint("CheckResult")
    private void carsSubscribe() {
        FleetActivity.fleetActivityRefresher.subscribe(
                result->{
                    if(result.equals(ObserverStringResponse.SUCCESS_RESPONSE)){
                        openFleetActivity();
                    }
                }
        );
    }


    @SuppressLint("CheckResult")
    private void driverSubscribe() {
        DriversActivity.driverActivityRefresher.subscribe(
                result->{
                    if(result.equals(ObserverStringResponse.SUCCESS_RESPONSE)){
                        openDriverActivity();
                    }
                }
        );

    }

    private void openFleetActivity() {
        Intent intent=new Intent(this, FleetActivity.class);
        startActivity(intent);
        finishAffinity();
    }


    private void openDriverActivity() {
        Intent intent=new Intent(this, DriversActivity.class);
        startActivity(intent);
        finishAffinity();
    }
}