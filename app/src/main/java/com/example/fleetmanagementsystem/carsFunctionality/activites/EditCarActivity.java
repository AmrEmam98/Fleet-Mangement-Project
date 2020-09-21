package com.example.fleetmanagementsystem.carsFunctionality.activites;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.fleetmanagementsystem.Constants.BundleKeys;
import com.example.fleetmanagementsystem.FirebaseServices.EditDataInFireStore;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.databinding.ActivityEditCarBinding;

public class EditCarActivity extends AppCompatActivity {
    FleetModel currentCar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_car);
       currentCar=(FleetModel) getIntent().getSerializableExtra(BundleKeys.FLEET_MODEL_KEY);
        ActivityEditCarBinding editCarBinding= DataBindingUtil.setContentView(this,R.layout.activity_edit_car);
        editCarBinding.setFleeModel(currentCar);
    }

    public void editCarOnClick(View view) {
        EditDataInFireStore.editFleet(currentCar);
    }
}