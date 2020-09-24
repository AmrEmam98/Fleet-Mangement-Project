package com.example.fleetmanagementsystem.carsFunctionality.activites;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.fleetmanagementsystem.Constants.BundleKeys;
import com.example.fleetmanagementsystem.Constants.ObserverStringResponse;
import com.example.fleetmanagementsystem.FirebaseServices.EditDataInFireStore;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.databinding.ActivityEditCarBinding;

public class EditCarActivity extends AppCompatActivity {
    FleetModel currentCar;
    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_car);
        currentCar = (FleetModel) getIntent().getSerializableExtra(BundleKeys.FLEET_MODEL_KEY);
        ActivityEditCarBinding editCarBinding = DataBindingUtil.setContentView(this, R.layout.activity_edit_car);
        editCarBinding.setFleeModel(currentCar);
        EditDataInFireStore.fleetEditedSubject.subscribe(
                result->{
                    if(result.equals(ObserverStringResponse.SUCCESS_RESPONSE)){
                        Toast.makeText(this,"Fleet Edited",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void editCarOnClick(View view) {

        EditDataInFireStore.editFleet(currentCar);
    }
}