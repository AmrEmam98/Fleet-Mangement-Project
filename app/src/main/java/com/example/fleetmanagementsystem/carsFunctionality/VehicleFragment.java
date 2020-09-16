package com.example.fleetmanagementsystem.carsFunctionality;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fleetmanagementsystem.FirebaseServices.RetrieveDataFromFireStore;
import com.example.fleetmanagementsystem.R;

import java.util.List;

public class VehicleFragment extends Fragment {

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
        fleetAdapter = new FleetAdapter();

        vehicleRecyclerView.setLayoutManager(new GridLayoutManager(getContext() , 2));
        vehicleRecyclerView.setAdapter(fleetAdapter);

        new RetrieveDataFromFireStore().retrieveTrucks();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getVehicles();
    }


    public void getVehicles() {
        RetrieveDataFromFireStore.trucksSubject.subscribe(carModels -> {
            this.vehicleModel = carModels;
            fleetAdapter.setList(vehicleModel);
        });
    }

}