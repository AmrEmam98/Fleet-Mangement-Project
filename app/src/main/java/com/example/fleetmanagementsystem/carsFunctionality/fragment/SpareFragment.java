package com.example.fleetmanagementsystem.carsFunctionality.fragment;

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
import com.example.fleetmanagementsystem.carsFunctionality.activites.FleetActivity;
import com.example.fleetmanagementsystem.carsFunctionality.activites.ListenFromActivity;
import com.example.fleetmanagementsystem.carsFunctionality.adapter.FleetAdapter;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;

import java.util.List;


public class SpareFragment extends Fragment implements ListenFromActivity {

    private List<FleetModel> carsList;
    private FleetAdapter fleetAdapter;
    private RecyclerView spareRecyclerView;

    public SpareFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((FleetActivity)getActivity()).setActivityListener(SpareFragment.this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_spare, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        spareRecyclerView = view.findViewById(R.id.spare_recycler_view);
        fleetAdapter = new FleetAdapter(R.drawable.spare_icon);
//
//        imageView = view.findViewById(R.id.car_image);
//        carName = view.findViewById(R.id.driver_number);
//        carChasisiNum = view.findViewById(R.id.chassisNum);
//        carPlateNum = view.findViewById(R.id.plateNum);

        spareRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        spareRecyclerView.setAdapter(fleetAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getCars();

        super.onActivityCreated(savedInstanceState);

    }

    public void getCars() {
        FleetActivity fleetActivity=(FleetActivity)getActivity();
        this.carsList=fleetActivity.fleetFilter.getSpare();
        fleetAdapter.setList(carsList);
    }

    @Override
    public void doSearchInFragment(String searchKey) {
        fleetAdapter.getFilter().filter(searchKey);
    }
}