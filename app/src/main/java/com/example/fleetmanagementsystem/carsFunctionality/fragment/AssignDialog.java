package com.example.fleetmanagementsystem.carsFunctionality.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.fleetmanagementsystem.CarDriverAssignment;
import com.example.fleetmanagementsystem.Constants.ObserverStringResponse;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.activites.FleetActivity;
import com.example.fleetmanagementsystem.carsFunctionality.models.CarHistoryModel;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;


public class AssignDialog extends AppCompatDialogFragment {

    Button assignBtn, CanelBtn;
    FleetModel currentFleet;
    DriverModel currentDriver;

//    public static AssignDialog newInstance() {
//        AssignDialog frag = new AssignDialog();
//        return frag;
//    }

    public  AssignDialog(FleetModel currentCar, DriverModel currentDriver){
        this.currentFleet=currentCar;
        this.currentDriver=currentDriver;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_assign_dialog, null);
        builder.setView(view);

        setCancelable(false);

        assignBtn = view.findViewById(R.id.assign_btn);

        assignBtn.setOnClickListener(view1 -> {
            CarHistoryModel carHistoryModel=new CarHistoryModel(currentDriver.getDriverId(),currentDriver.getName());
            currentFleet.carHistoryList.add(carHistoryModel);
            CarDriverAssignment.assign(currentFleet,currentDriver);
            Toast.makeText(getContext() , "Driver added to your car" , Toast.LENGTH_LONG).show();
            FleetActivity.fleetActivityRefresher.onNext(ObserverStringResponse.SUCCESS_RESPONSE);
            dismiss();
        });

        return builder.create();
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);

    }
}