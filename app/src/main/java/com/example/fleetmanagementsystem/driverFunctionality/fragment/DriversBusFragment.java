package com.example.fleetmanagementsystem.driverFunctionality.fragment;

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

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.driverFunctionality.activities.DriversActivity;
import com.example.fleetmanagementsystem.driverFunctionality.adapter.DriversAdapter;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;

import java.util.List;

public class DriversBusFragment extends Fragment {

    private List<DriverModel> driverModels;
    private DriversAdapter driverAdapter;
    private RecyclerView recyclerView;

    public DriversBusFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drivers_bus, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.drivers_bus_recyclerView);
        driverAdapter = new DriversAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(driverAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDrivers();
    }

    @SuppressLint("CheckResult")
    public void getDrivers() {
        DriversActivity driversActivity = (DriversActivity)getActivity();
        this.driverModels = driversActivity.driverFilter.getBus();
        driverAdapter.setList(driverModels);
    }

}