package com.example.fleetmanagementsystem.carsFunctionality.activites;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleetmanagementsystem.Constants.BundleKeys;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.adapter.HistoryAdapter;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;

public class CarHistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HistoryAdapter historyAdapter;
    FleetModel fleetModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_history);
        fleetModel=(FleetModel)getIntent().getSerializableExtra(BundleKeys.FLEET_MODEL_KEY);
        recyclerView = findViewById(R.id.histroy_recycler);
        historyAdapter = new HistoryAdapter();
        historyAdapter.setList(fleetModel.carHistoryList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(historyAdapter);
    }
}