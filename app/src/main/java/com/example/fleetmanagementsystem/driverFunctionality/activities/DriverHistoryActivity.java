package com.example.fleetmanagementsystem.driverFunctionality.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fleetmanagementsystem.carsFunctionality.adapter.HistoryAdapter;
import com.example.fleetmanagementsystem.driverFunctionality.adapter.DriverHistoryAdapter;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;
import com.example.fleetmanagementsystem.Constants.BundleKeys;


public class DriverHistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DriverHistoryAdapter driverHistoryAdapter;
    private DriverModel driverModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_history);

        driverModel = (DriverModel) getIntent().getSerializableExtra(BundleKeys.DRIVER_MODEL_KEY);

        recyclerView = findViewById(R.id.histroy_recycler_driver);
        driverHistoryAdapter = new DriverHistoryAdapter();

        driverHistoryAdapter.setList(driverModel.getDriverHistoryModelList());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(driverHistoryAdapter);
    }

    public void finishHistoryActivity(View view) {
        finish();
    }
}