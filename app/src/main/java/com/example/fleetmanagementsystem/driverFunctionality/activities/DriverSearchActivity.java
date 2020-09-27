package com.example.fleetmanagementsystem.driverFunctionality.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.driverFunctionality.adapter.DriversAdapter;

import android.os.Bundle;
import android.widget.EditText;

public class DriverSearchActivity extends AppCompatActivity {

    private DriversAdapter driversAdapter;
    private RecyclerView searchRecyclerView;
    private EditText searchEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_search);

    }
}