package com.example.fleetmanagementsystem.carsFunctionality.fragment;

import android.content.Intent;
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

import com.example.fleetmanagementsystem.FirebaseServices.RetrieveDataFromFireStore;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.activites.CarDetailsActivity;
import com.example.fleetmanagementsystem.carsFunctionality.adapter.FleetAdapter;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;

import java.util.List;


public class CarsFragment extends Fragment implements FleetAdapter.onItemClicked {

    private List<FleetModel> carModel;
    private FleetAdapter fleetAdapter;
    private RecyclerView carRecyclerView;

    ImageView imageView;
    TextView carName, carDriver, carLiences;

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
        fleetAdapter = new FleetAdapter(this);

        imageView = view.findViewById(R.id.car_image);
        carName = view.findViewById(R.id.car_name);
        carLiences = view.findViewById(R.id.car_license);
        carDriver = view.findViewById(R.id.driver_name);

        carRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        carRecyclerView.setAdapter(fleetAdapter);

         RetrieveDataFromFireStore.retrieveAllCars();
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

    @Override
    public void onItemClicked(int position) {
        Intent intent = new Intent(getContext(), CarDetailsActivity.class);
        startActivity(intent);

       /* Pair[] pairs =  new Pair[4];
        pairs[0] = new Pair<View , String>(imageView , "carImageTransition");
        pairs[1] = new Pair<View , String>(carName , "carModelTransition");
        pairs[2] = new Pair<View , String>(carLiences , "carLiesnceTransition");
        pairs[2] = new Pair<View , String>(carDriver , "carDriverTransition");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) getContext(), pairs);

        startActivity(intent , options.toBundle());

        */
    }
}