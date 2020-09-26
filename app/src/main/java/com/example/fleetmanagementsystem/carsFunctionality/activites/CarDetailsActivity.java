package com.example.fleetmanagementsystem.carsFunctionality.activites;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;

import com.example.fleetmanagementsystem.Constants.BundleKeys;
import com.example.fleetmanagementsystem.FirebaseServices.RetrieveDataFromFireStore;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.fragment.DeleteDialog;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.databinding.ActivityCarDetailsBinding;
import com.example.fleetmanagementsystem.driverFunctionality.activities.DriversDetailsActivity;

import static com.example.fleetmanagementsystem.Constants.BundleKeys.FLEET_MODEL_KEY;

public class CarDetailsActivity extends AppCompatActivity {

    FleetModel currentCar=new FleetModel();
    TextView driverNameTextView;
    CardView cardView;
    ImageView vehicleImage;
    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_car_details);
        currentCar=(FleetModel) getIntent().getExtras().getSerializable(FLEET_MODEL_KEY);

        ActivityCarDetailsBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_car_details);
        driverNameTextView=findViewById(R.id.driver_name_details);
        cardView=findViewById(R.id.driver_cardView);
        vehicleImage = findViewById(R.id.details_image);
        vehicleImage.setImageResource(getIntent().getExtras().getInt("CAR_IMAGE"));
        binding.setFleeModel(currentCar);
       if(currentCar.getAssignedDriverId()!=null){
       RetrieveDataFromFireStore.retrieveDriverByID(currentCar.assignedDriverId);
       RetrieveDataFromFireStore.singleDriverSubject.subscribe(
               driverModel->{
                   driverNameTextView.setText(driverModel.getName());
                   cardView.setOnClickListener(
                           view -> {
                               Intent intent=new Intent(this, DriversDetailsActivity.class);
                               Bundle bundle=new Bundle();
                               bundle.putSerializable(BundleKeys.DRIVER_MODEL_KEY,driverModel);
                               intent.putExtras(bundle);
                               startActivity(intent);
                           }
                   );
               }
       );
       }
       else{
           driverNameTextView.setText("No Driver for this car yet");
       }

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
        Bundle bundle=new Bundle();
        bundle.putSerializable(FLEET_MODEL_KEY,currentCar);
        historyIntent.putExtras(bundle);
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

    public void finishDetailsActivity(View view) {
        finish();
    }
}