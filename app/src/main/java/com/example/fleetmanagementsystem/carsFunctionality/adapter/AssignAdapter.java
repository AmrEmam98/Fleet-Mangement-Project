package com.example.fleetmanagementsystem.carsFunctionality.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.activites.AssignActivity;
import com.example.fleetmanagementsystem.carsFunctionality.activites.CarDetailsActivity;
import com.example.fleetmanagementsystem.carsFunctionality.fragment.AssignDialog;
import com.example.fleetmanagementsystem.carsFunctionality.fragment.DeleteDialog;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.driverFunctionality.activities.AddDriverActivity;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.fleetmanagementsystem.Constants.BundleKeys.FLEET_MODEL_KEY;

public class AssignAdapter extends RecyclerView.Adapter<AssignAdapter.AssignViewHolder> {

    private List<DriverModel> driverAssignList = new ArrayList<>();
    public AssignAdapter(Activity context) {
        this.context=context;

    }
    public Activity context;
    @NonNull
    @Override
    public AssignViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       AssignViewHolder assignViewHolder = new AssignViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.assign_driver_item, parent, false));
        return assignViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AssignViewHolder holder, int position) {
        holder.initData(context);
    }

    @Override
    public int getItemCount() {
        //TODO handle return list.size
        return 15;
    }

    public class AssignViewHolder extends RecyclerView.ViewHolder {

        TextView driverName , driverPhone;
        ImageView driverImage , addDriverIcon;

        public AssignViewHolder(@NonNull View itemView) {
            super(itemView);
            driverName = itemView.findViewById(R.id.driver_name_assign);
            driverPhone = itemView.findViewById(R.id.driver_assign_phone);
            driverImage = itemView.findViewById(R.id.assign_driver_image);
            addDriverIcon = itemView.findViewById(R.id.assign_driver_icon);
        }

        public void initData(Context context){
        addDriverIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   AssignDialog assignDialog = AssignDialog.newInstance();
                   assignDialog.show(((AssignActivity)context).getSupportFragmentManager(),"Title");
                }
            });
        }
    }

}
