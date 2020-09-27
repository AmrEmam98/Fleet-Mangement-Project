package com.example.fleetmanagementsystem.driverFunctionality.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.fleetmanagementsystem.Constants.BundleKeys;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;
import com.example.fleetmanagementsystem.driverFunctionality.adapter.AssignDriverAdapter;

public class DriverAssignActivity extends AppCompatActivity {

    private AssignDriverAdapter assignAdapter;
    private RecyclerView assignCarRecycler;
    DriverModel currentDriver;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_assign);

        searchView = findViewById(R.id.search_icon_assign);
        assignCarRecycler = findViewById(R.id.recyclerView_assign_car);

        currentDriver=(DriverModel)getIntent().getSerializableExtra(BundleKeys.DRIVER_MODEL_KEY);
        assignAdapter = new AssignDriverAdapter(this,currentDriver);
        assignCarRecycler.setLayoutManager(new LinearLayoutManager(this));
        assignCarRecycler.setAdapter(assignAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                assignAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    public void finishAssignActivity(View view) {
        finish();
    }
}