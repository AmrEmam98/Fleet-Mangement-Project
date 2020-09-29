package com.example.fleetmanagementsystem.homeFunctionality;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fleetmanagementsystem.Constants.BundleKeys;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.loginFunctionality.activities.LoginActivity;
import com.example.fleetmanagementsystem.splashScreens.LoadingActivity;
import com.google.firebase.auth.FirebaseAuth;


public class HomeActivity extends AppCompatActivity {



    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    public void doInLoginDrivers(View view) {
        Intent intent = new Intent(this, LoadingActivity.class);
        intent.putExtra(BundleKeys.ACTIVITY_TYPE,BundleKeys.DRIVER_ACTIVITY_TYPE);
        startActivity(intent);
    }

    public void doInLoginVehicles(View view) {
        Intent intent = new Intent(this, LoadingActivity.class);
        intent.putExtra(BundleKeys.ACTIVITY_TYPE,BundleKeys.CAR_ACTIVITY_TYPE);
        startActivity(intent);
    }

    public void signOutClick(View view) {
        FirebaseAuth.getInstance().signOut();
        Intent intent=new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}