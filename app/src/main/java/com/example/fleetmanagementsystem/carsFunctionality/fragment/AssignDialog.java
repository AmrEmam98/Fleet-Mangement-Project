package com.example.fleetmanagementsystem.carsFunctionality.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.fleetmanagementsystem.FirebaseServices.DeleteDataFromFireStore;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;


public class AssignDialog extends AppCompatDialogFragment {

    Button assignBtn, CanelBtn;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_assign_dialog, null);
        builder.setView(view);

        setCancelable(false);

        assignBtn = view.findViewById(R.id.assign_btn);

        assignBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(getContext() , "Driver added to your car" , Toast.LENGTH_LONG).show();
                dismiss();
            }
        });

        return builder.create();
    }

}