package com.example.fleetmanagementsystem.carsFunctionality;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fleetmanagementsystem.R;

import java.util.ArrayList;
import java.util.List;

public class CarDetailsActivity extends AppCompatActivity implements DetailsAdapter.onItemClicked {


    private DetailsAdapter detailsAdapter;
    private RecyclerView detailsRecyclerView;
    private List<FleetModel> carModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        detailsRecyclerView= findViewById(R.id.details_recyclerView);
        detailsAdapter = new DetailsAdapter(this);

        detailsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        detailsRecyclerView.setAdapter(detailsAdapter);

        carModel = new ArrayList<>();
        carModel.add(new FleetModel());
        carModel.add(new FleetModel());
        carModel.add(new FleetModel());
        carModel.add(new FleetModel());
        carModel.add(new FleetModel());
        carModel.add(new FleetModel());
        carModel.add(new FleetModel());
        carModel.add(new FleetModel());
        carModel.add(new FleetModel());

        detailsAdapter.setList(carModel);

    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(CarDetailsActivity.this , "Edit Icon Clicked" , Toast.LENGTH_LONG).show();
    }
}