package com.example.fleetmanagementsystem.carsFunctionality.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.fleetmanagementsystem.FirebaseServices.DeleteDataFromFireStore;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.splashScreens.LoadingActivity;

public class DeleteDialog extends AppCompatDialogFragment {

    Context mContext;
    Button deleteBtn, CanelBtn;
    FleetModel currentCar;
    public DeleteDialog(FleetModel fleetModel , Context context){
        currentCar=fleetModel;
        this.mContext = context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_delete, null);
        builder.setView(view);

        setCancelable(false);

        deleteBtn = view.findViewById(R.id.delete_btn);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeleteDataFromFireStore.deleteFleet(currentCar);
                Toast.makeText(getContext() , "Done: Car Deleted" , Toast.LENGTH_LONG).show();
                dismiss();
            }
        });

        return builder.create();
    }

}
