package com.example.fleetmanagementsystem.carsFunctionality.activites;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.fleetmanagementsystem.FirebaseServices.AddDataToFireStore;
import com.example.fleetmanagementsystem.InputValidation;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.viewModels.AddCarViewModel;

import static com.example.fleetmanagementsystem.Constants.ObserverStringResponse.SUCCESS_RESPONSE;

public class AddCarActivity extends AppCompatActivity  {

    EditText carNameEt;
    EditText carModelEt;
    EditText carPlateNumEt;
    EditText carChassisNum;
    EditText carColorEt;
    AddCarViewModel carViewModel;
    Spinner carTypeSpinner;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        carModelEt=findViewById(R.id.et_addCarModel);
        carNameEt=findViewById(R.id.et_addCarName);
        carPlateNumEt=findViewById(R.id.et_addCarPlateNumber);
        carViewModel= new ViewModelProvider(this).get(AddCarViewModel.class);
        carTypeSpinner=findViewById(R.id.vehicleType_spinner);
        carColorEt =findViewById(R.id.et_addCarColor);
        carChassisNum=findViewById(R.id.et_chassisNum);
        subscribe();
    }

    @SuppressLint("CheckResult")
    private void subscribe() {
        AddDataToFireStore.addCarSubject.subscribe(
                result->{
                    if(result.equals(SUCCESS_RESPONSE)) {
                        Toast.makeText(this, "Vehicle Added Successfully", Toast.LENGTH_LONG).show();
                        FleetActivity.fleetActivityRefresher.onNext(SUCCESS_RESPONSE);
                        finish();
                    }
                    else
                        Toast.makeText(this,"Error Happened",Toast.LENGTH_LONG).show();
                }
        );
    }

    public void addCarClick(View view) {
        if(
                InputValidation.validateEmptyString(carNameEt)&&
                InputValidation.validateEmptyString(carModelEt)&&
                InputValidation.validateEmptyString(carPlateNumEt)&&
                InputValidation.validateEmptyString(carChassisNum)&&
                InputValidation.validateEmptyString(carColorEt)
        ) {
            String carName = carNameEt.getText().toString();
            String carModel = carModelEt.getText().toString();
            String plateNum = carPlateNumEt.getText().toString();
            String chassisNum = carChassisNum.getText().toString();
            String carColor = carColorEt.getText().toString();
            String carType = carTypeSpinner.getSelectedItem().toString();
            carViewModel.addCar(carName, carModel, plateNum, chassisNum, carColor, carType);
            //show progress bar
            //subscribe();

        }

    }

}