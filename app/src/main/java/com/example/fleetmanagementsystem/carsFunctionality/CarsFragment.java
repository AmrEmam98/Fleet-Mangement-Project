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


public class CarsFragment extends Fragment {

    private List<FleetModel> carModel;
    private FleetAdapter fleetAdapter;
    private RecyclerView carRecyclerView;

    public CarsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cars, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        carRecyclerView = view.findViewById(R.id.car_recycler_view);
        fleetAdapter = new FleetAdapter();

        carRecyclerView.setLayoutManager(new GridLayoutManager(getContext() , 2));
        carRecyclerView.setAdapter(fleetAdapter);

        new RetrieveDataFromFireStore().retrieveAllCars();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getCars();
    }

    public void getCars() {
        RetrieveDataFromFireStore.carsSubject.subscribe(carModels -> {
            this.carModel = carModels;
            fleetAdapter.setList(carModel);
        });
    }
}