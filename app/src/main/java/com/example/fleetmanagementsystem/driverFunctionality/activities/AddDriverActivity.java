package com.example.fleetmanagementsystem.driverFunctionality.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.fleetmanagementsystem.Constants.ObserverStringResponse;
import com.example.fleetmanagementsystem.FirebaseServices.AddDataToFireStore;
import com.example.fleetmanagementsystem.InputValidation;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.driverFunctionality.viewModels.AddDriverViewModel;

public class AddDriverActivity extends AppCompatActivity {

    EditText driverNameEt;
    EditText driverPhoneEt;
    AddDriverViewModel driverViewModel;
    Spinner driverTypeSpinner;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_driver);
        driverNameEt=findViewById(R.id.et_addDriverName);
        driverPhoneEt=findViewById(R.id.et_addDriverPhoneNumber);
        driverViewModel= new ViewModelProvider(this).get(AddDriverViewModel.class);
        driverTypeSpinner = findViewById(R.id.driverType_spinner);

        AddDataToFireStore.addDriverSubject.subscribe(
                result->{
                    if(result.equals(ObserverStringResponse.SUCCESS_RESPONSE)){
                        Toast.makeText(this, "Driver Added Successfully", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(this, "Error Adding Driver", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void addDriverClicked(View view) {

        if(
                InputValidation.validateEmptyString(driverNameEt)&&
                InputValidation.validatePhoneNumber(driverPhoneEt)
        ) {
            String name = driverNameEt.getText().toString();
            String phone = driverPhoneEt.getText().toString();
            String type = driverTypeSpinner.getSelectedItem().toString();
            driverViewModel.doAddDriver(name, phone, type);
        }

    }
}