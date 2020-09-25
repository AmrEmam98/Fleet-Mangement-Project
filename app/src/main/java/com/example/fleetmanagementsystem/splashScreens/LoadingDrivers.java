package com.example.fleetmanagementsystem.splashScreens;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fleetmanagementsystem.R;

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
    }
}