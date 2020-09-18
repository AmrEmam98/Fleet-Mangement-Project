package com.example.fleetmanagementsystem.driverFunctionality;

import android.content.Intent;
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
import com.example.fleetmanagementsystem.driverFunctionality.activities.DriversDetailsActivity;
import com.example.fleetmanagementsystem.driverFunctionality.adapter.DriversAdapter;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;

import java.util.List;

import io.reactivex.functions.Consumer;


public class DriversSpareFragment extends Fragment implements DriversAdapter.onItemClicked{

    private List<DriverModel> driverModels;
    private DriversAdapter driverAdapter;
    private RecyclerView recyclerView;

    public DriversSpareFragment() {
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
        return inflater.inflate(R.layout.fragment_drivers_spare, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.drivers_spare_recyclerView);
        driverAdapter = new DriversAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(driverAdapter);

        new RetrieveDataFromFireStore().retrieveAllDrivers();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDrivers();
    }

    public void getDrivers() {
        RetrieveDataFromFireStore.driverSubject.subscribe(new Consumer<List<DriverModel>>() {
            @Override
            public void accept(List<DriverModel> driverModels) throws Exception {
                DriversSpareFragment.this.driverModels = driverModels;
                driverAdapter.setList(driverModels);
            }
        });
    }

    @Override
    public void onItemClicked(int postion) {
        Intent intent = new Intent(getContext(), DriversDetailsActivity.class);
        startActivity(intent);
    }
}