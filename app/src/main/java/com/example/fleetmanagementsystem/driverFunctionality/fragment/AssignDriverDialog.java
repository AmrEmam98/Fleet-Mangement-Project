package com.example.fleetmanagementsystem.driverFunctionality.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.fleetmanagementsystem.CarDriverAssignment;
import com.example.fleetmanagementsystem.Constants.ObserverStringResponse;
import com.example.fleetmanagementsystem.FirebaseServices.EditDataInFireStore;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.driverFunctionality.activities.DriversActivity;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;

public class AssignDriverDialog extends AppCompatDialogFragment {

    Button assignBtn, canelBtn;
    FleetModel currentCar;
    DriverModel currentDriver;

    View view;

    @SuppressLint("CheckResult")
    public  AssignDriverDialog(FleetModel currentCar, DriverModel currentDriver){
        this.currentCar =currentCar;
        this.currentDriver=currentDriver;
        EditDataInFireStore.driverEditedSubject.subscribe(
                result->{
                    if(result.equals(ObserverStringResponse.DRIVER_ASSIGNMENT)){
                        DriversActivity.driverActivityRefresher.onNext(ObserverStringResponse.SUCCESS_RESPONSE);
                        dismiss();
                    }
                }
        );
    }

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.driver_assign_dialog, null);
        builder.setView(view);

        setCancelable(false);

        assignBtn(view);
        cancelBtn(view);

        return builder.create();
    }

    private void assignBtn(View view){
        assignBtn = view.findViewById(R.id.assign_car_btn);

        assignBtn.setOnClickListener(view1 -> {
            CarDriverAssignment.assign(currentCar,currentDriver,"Driver");

        });
    }
    private void cancelBtn(View view){
        canelBtn = view.findViewById(R.id.cancel_assign_btn);
        canelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}
