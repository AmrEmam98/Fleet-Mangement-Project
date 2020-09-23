package com.example.fleetmanagementsystem.splashScreens;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fleetmanagementsystem.Constants.ObserverStringResponse;
import com.example.fleetmanagementsystem.FirebaseServices.RetrieveDataFromFireStore;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.activites.FleetActivity;

public class LoadingActivity extends AppCompatActivity {
    ProgressBar progressBar;
    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        progressBar=findViewById(R.id.loadingProgressBar);
        RetrieveDataFromFireStore.retrieveAllCars();
        RetrieveDataFromFireStore.carsCompleteSubject.subscribe(
                result->{
                    if(result.equals(ObserverStringResponse.SUCCESS_RESPONSE)){
                        progressBar.setVisibility(View.GONE);
                        Intent intent=new Intent(this, FleetActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }
}