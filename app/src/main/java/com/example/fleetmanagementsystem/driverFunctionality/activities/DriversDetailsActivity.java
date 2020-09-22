package com.example.fleetmanagementsystem.driverFunctionality.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;
import com.example.fleetmanagementsystem.databinding.ActivityDriversDetailsBinding;
import com.example.fleetmanagementsystem.Constants.BundleKeys;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.driverFunctionality.fragment.DeleteDriverFragment;

public class DriversDetailsActivity extends AppCompatActivity {
    DriverModel driverModel = new DriverModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_drivers_details);
        driverModel = (DriverModel)getIntent().getExtras().getSerializable(BundleKeys.DRIVER_MODEL_KEY);
        ActivityDriversDetailsBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_drivers_details);
        binding.setDriverModel(driverModel);
    }

    public void showHistory(View view) {
    }

    public void editDriver(View view) {
        Intent intent = new Intent(this,EditDriverAcitivty.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(BundleKeys.DRIVER_MODEL_KEY,driverModel);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void openDeleteDialog(View view) {
        DeleteDriverFragment deleteDriver = new DeleteDriverFragment(driverModel);
        deleteDriver.show(getSupportFragmentManager(),"Dialogue Driver");
    }
}