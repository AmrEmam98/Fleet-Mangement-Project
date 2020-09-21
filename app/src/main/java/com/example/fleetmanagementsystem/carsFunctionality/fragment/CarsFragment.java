package com.example.fleetmanagementsystem.carsFunctionality.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.activites.FleetActivity;
import com.example.fleetmanagementsystem.carsFunctionality.adapter.FleetAdapter;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;

import java.util.List;


public class CarsFragment extends Fragment  {

    private List<FleetModel> carsList;
    private FleetAdapter fleetAdapter;
    private RecyclerView carRecyclerView;

    ImageView imageView;
    TextView carName, carPlateNum, carChasisiNum;

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
        imageView = view.findViewById(R.id.car_image);
        carName = view.findViewById(R.id.car_name);
        carChasisiNum = view.findViewById(R.id.chassisNum);
        carPlateNum = view.findViewById(R.id.plateNum);
        carRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        carRecyclerView.setAdapter(fleetAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getCars();
    }

    public void getCars() {
        FleetActivity fleetActivity=(FleetActivity)getActivity();
        this.carsList=fleetActivity.fleetFilter.getSpare();
        fleetAdapter.setList(carsList);
    }


}