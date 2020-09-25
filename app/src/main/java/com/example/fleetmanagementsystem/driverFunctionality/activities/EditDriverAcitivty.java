package com.example.fleetmanagementsystem.driverFunctionality.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.fleetmanagementsystem.Constants.BundleKeys;
import com.example.fleetmanagementsystem.Constants.ObserverStringResponse;
import com.example.fleetmanagementsystem.FirebaseServices.EditDataInFireStore;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.databinding.ActivityEditDriverAcitivtyBinding;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;

public class EditDriverAcitivty extends AppCompatActivity {
    DriverModel driverModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_driver_acitivty);

        driverModel = (DriverModel)getIntent().getSerializableExtra(BundleKeys.DRIVER_MODEL_KEY);
        ActivityEditDriverAcitivtyBinding activityEditDriverAcitivtyBinding = DataBindingUtil.setContentView(this,R.layout.activity_edit_driver_acitivty);
        activityEditDriverAcitivtyBinding.setDriverModel(driverModel);
    }

    public void editDriverOnClick(View view) {
        EditDataInFireStore.editDriver(driverModel);
        DriversActivity.driverActivityRefresher.onNext(ObserverStringResponse.SUCCESS_RESPONSE);
        Toast.makeText(this, "Driver Updated", Toast.LENGTH_LONG).show();
    }
}