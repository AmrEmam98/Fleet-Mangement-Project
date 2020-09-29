package com.example.fleetmanagementsystem.driverFunctionality.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleetmanagementsystem.FirebaseServices.RetrieveDataFromFireStore;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.driverFunctionality.adapter.DriversAdapter;

public class DriverSearchActivity extends AppCompatActivity {

    private DriversAdapter driversAdapter;
    private RecyclerView searchRecyclerView;
    private EditText searchEt;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_search);
        searchEt = findViewById(R.id.et_search_driver);

        searchRecyclerView = findViewById(R.id.search_recycler_driver);
        driversAdapter = new DriversAdapter(R.drawable.ic_driver);
        RetrieveDataFromFireStore.driverSubject.subscribe(
                driverModels -> {
                    driversAdapter.setList(driverModels);
                }
        );

        searchRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchRecyclerView.setAdapter(driversAdapter);



        searchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                driversAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}