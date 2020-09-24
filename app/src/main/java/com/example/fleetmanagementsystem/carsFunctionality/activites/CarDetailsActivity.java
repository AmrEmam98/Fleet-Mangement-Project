package com.example.fleetmanagementsystem.carsFunctionality.activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.fragment.DeleteDialog;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.databinding.ActivityCarDetailsBinding;

import static com.example.fleetmanagementsystem.Constants.BundleKeys.FLEET_MODEL_KEY;

public class CarDetailsActivity extends AppCompatActivity {

    FleetModel currentCar=new FleetModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_car_details);
        currentCar=(FleetModel) getIntent().getExtras().getSerializable(FLEET_MODEL_KEY);
        ActivityCarDetailsBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_car_details);
        binding.setFleeModel(currentCar);

    }

    @Override
    protected void onResume() {
        Log.d("Resume","Car Detailes Activity resumed");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("PAUSE","Car Detailes Activity paused");
        super.onPause();
    }

    public void openDeleteDialog(View view) {
        DeleteDialog deleteDialog = new DeleteDialog(currentCar , this);
        deleteDialog.show(getSupportFragmentManager() , "Delete Dialog");


    }

    public void showHistory(View view) {
        Intent historyIntent = new Intent(this , CarHistoryActivity.class);
        startActivity(historyIntent);
    }

    public void editCar(View view) {
        Intent editIntent = new Intent(this , EditCarActivity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable(FLEET_MODEL_KEY,currentCar);
        editIntent.putExtras(bundle);
        startActivity(editIntent);
    }

    public void openAssignPage(View view) {

        Intent assignIntent = new Intent(this , AssignActivity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable(FLEET_MODEL_KEY,currentCar);
        assignIntent.putExtras(bundle);
        startActivity(assignIntent);

    }
}