package com.example.fleetmanagementsystem.carsFunctionality.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleetmanagementsystem.FirebaseServices.RetrieveDataFromFireStore;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.adapter.FleetAdapter;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;

import java.util.List;

public class VehicleFragment extends Fragment implements FleetAdapter.onItemClicked{

    private List<FleetModel> vehicleModel;
    private FleetAdapter fleetAdapter;
    private RecyclerView vehicleRecyclerView;

    public VehicleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vehicle, container, false);


    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        vehicleRecyclerView = view.findViewById(R.id.vehicle_recycler_view);
        fleetAdapter = new FleetAdapter(this);

        vehicleRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        vehicleRecyclerView.setAdapter(fleetAdapter);

         RetrieveDataFromFireStore.retrieveAllCars();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getVehicles();
    }

    @SuppressLint("CheckResult")
    public void getVehicles() {
        RetrieveDataFromFireStore.carsSubject.subscribe(carModels -> {
            this.vehicleModel = carModels;
            fleetAdapter.setList(vehicleModel);
        });
    }

    @Override
    public void onItemClicked(int position) {

    }
}