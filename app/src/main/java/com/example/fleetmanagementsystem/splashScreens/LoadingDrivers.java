package com.example.fleetmanagementsystem.splashScreens;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fleetmanagementsystem.Constants.ObserverStringResponse;
import com.example.fleetmanagementsystem.FirebaseServices.RetrieveDataFromFireStore;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.driverFunctionality.activities.DriversActivity;

import pl.droidsonroids.gif.GifImageView;


public class LoadingDrivers extends AppCompatActivity {
    //ProgressBar progressBar;

    GifImageView gifImageView;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_drivers);

        gifImageView=findViewById(R.id.loadingProgressBarDrivers);
        RetrieveDataFromFireStore.retrieveAllDrivers();
        RetrieveDataFromFireStore.driversCompleteSubject.subscribe(
                result->{
                    if(result.equals(ObserverStringResponse.SUCCESS_RESPONSE)){
                        gifImageView.setVisibility(View.GONE);
                        Intent intent=new Intent(this, DriversActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}