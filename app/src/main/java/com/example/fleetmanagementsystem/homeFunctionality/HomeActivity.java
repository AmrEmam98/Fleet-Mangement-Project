package com.example.fleetmanagementsystem.homeFunctionality;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.driverFunctionality.activities.DriversActivity;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;
import com.example.fleetmanagementsystem.splashScreens.*;

import java.util.List;


public class HomeActivity extends AppCompatActivity {

    List<FleetModel> fleetModels;
    private List<DriverModel> driverModels;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    public void doInLoginDrivers(View view) {
        Intent intent = new Intent(this, LoadingDrivers.class);
        startActivity(intent);
    }

    public void doInLoginVehicles(View view) {
        Intent intent = new Intent(this, LoadingActivity.class);
        startActivity(intent);
    }
}