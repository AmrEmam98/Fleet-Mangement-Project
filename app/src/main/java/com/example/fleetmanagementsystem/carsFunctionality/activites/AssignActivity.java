package com.example.fleetmanagementsystem.carsFunctionality.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.adapter.AssignAdapter;
import com.example.fleetmanagementsystem.carsFunctionality.adapter.FleetAdapter;

public class AssignActivity extends AppCompatActivity {

    private AssignAdapter assignAdapter;
    private RecyclerView assignCarRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign);

        assignCarRecycler = findViewById(R.id.recyclerView_assign_driver);
        assignAdapter = new AssignAdapter(this);
        assignCarRecycler.setLayoutManager(new LinearLayoutManager(this));
        assignCarRecycler.setAdapter(assignAdapter);

    }
}