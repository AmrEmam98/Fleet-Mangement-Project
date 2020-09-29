package com.example.fleetmanagementsystem.driverFunctionality.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;

import com.example.fleetmanagementsystem.CarDriverAssignment;
import com.example.fleetmanagementsystem.Constants.BundleKeys;
import com.example.fleetmanagementsystem.Constants.ObserverStringResponse;
import com.example.fleetmanagementsystem.FirebaseServices.EditDataInFireStore;
import com.example.fleetmanagementsystem.FirebaseServices.RetrieveDataFromFireStore;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.activites.CarDetailsActivity;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.databinding.ActivityDriversDetailsBinding;
import com.example.fleetmanagementsystem.driverFunctionality.fragment.DeleteDriverFragment;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;

import static com.example.fleetmanagementsystem.Constants.BundleKeys.DRIVER_MODEL_KEY;
import static com.example.fleetmanagementsystem.Constants.ObserverStringResponse.SUCCESS_RESPONSE;

public class DriversDetailsActivity extends AppCompatActivity {

    DriverModel currentDriver;
    FleetModel currentCar = new FleetModel();

    TextView carNameTextView;
    CardView cardView;
    ImageView driverImage;
    Button assignBtn;

    boolean isAssigned=false;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_drivers_details);
        currentDriver = (DriverModel)getIntent().getExtras().getSerializable(BundleKeys.DRIVER_MODEL_KEY);
        ActivityDriversDetailsBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_drivers_details);
        initUI();
        binding.setDriverModel(currentDriver);
        EditDataInFireStore.driverEditedSubject.subscribe(
                result->{
                    if(result.equals(ObserverStringResponse.DRIVER_UNASSIGNMENT))
                    DriversActivity.driverActivityRefresher.onNext(SUCCESS_RESPONSE);
                }
        );
        if(currentDriver.getAssignedCarId()!=null){
            RetrieveDataFromFireStore.retrieveFleetByID(currentDriver.getAssignedCarId());
            RetrieveDataFromFireStore.singleCarSubject.subscribe(
                    carModel -> {
                        currentCar = carModel;
                        carNameTextView.setText(carModel.getName());
                        cardView.setOnClickListener(
                                view -> {
                                    Intent intent = new Intent(DriversDetailsActivity.this, CarDetailsActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putSerializable(BundleKeys.FLEET_MODEL_KEY, carModel);
                                    intent.putExtras(bundle);
                                    DriversDetailsActivity.this.startActivity(intent);
                                }
                        );
                    }
            );
        }
        else{
            carNameTextView.setText("No Cars for this driver yet");
        }
    }

    private void initUI(){
        carNameTextView = findViewById(R.id.tv_actual_car_name_driver);
        cardView = findViewById(R.id.car_card_view);
        driverImage = findViewById(R.id.iv_driver_detials);
        assignBtn = findViewById(R.id.assignCar_btn);

        driverImage.setImageResource(getIntent().getExtras().getInt("DRIVER_IMAGE"));

        isAssigned = !(currentDriver.getAssignedCarId()==null);

        assignBtn.setText(isAssigned?"Un Assign Car":"Assign New Car");
    }

    public void showHistory(View view) {
        Intent intent = new Intent(this,DriverHistoryActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(DRIVER_MODEL_KEY,currentDriver);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void editDriver(View view) {
        Intent intent = new Intent(this,EditDriverAcitivty.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(BundleKeys.DRIVER_MODEL_KEY, currentDriver);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void openDeleteDialog(View view) {
        DeleteDriverFragment deleteDriver = new DeleteDriverFragment(currentDriver);
        deleteDriver.show(getSupportFragmentManager(),"Dialogue Driver");
    }

    @SuppressLint("CheckResult")
    public void openAssignPage(View view) {
        if(!isAssigned)
            openAssignActivity();
        else{
            CarDriverAssignment.unAssign(currentCar,currentDriver,"Driver");
        }
    }

    private void openAssignActivity() {
        Intent assignIntent = new Intent(this , DriverAssignActivity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable(DRIVER_MODEL_KEY, currentDriver);
        assignIntent.putExtras(bundle);
        startActivity(assignIntent);
    }

    public void finishDetailsActivity(View view) {
        finish();
    }
}