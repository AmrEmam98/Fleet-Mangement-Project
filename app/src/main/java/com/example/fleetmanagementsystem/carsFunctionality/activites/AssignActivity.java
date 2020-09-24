package com.example.fleetmanagementsystem.carsFunctionality.activites;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleetmanagementsystem.Constants.BundleKeys;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.adapter.AssignAdapter;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;

public class AssignActivity extends AppCompatActivity {

    private AssignAdapter assignAdapter;
    private RecyclerView assignCarRecycler;
    FleetModel currentFleet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign);

        assignCarRecycler = findViewById(R.id.recyclerView_assign_driver);
        currentFleet=(FleetModel)getIntent().getSerializableExtra(BundleKeys.FLEET_MODEL_KEY);
        assignAdapter = new AssignAdapter(this,currentFleet);
        assignCarRecycler.setLayoutManager(new LinearLayoutManager(this));
        assignCarRecycler.setAdapter(assignAdapter);


    }
}