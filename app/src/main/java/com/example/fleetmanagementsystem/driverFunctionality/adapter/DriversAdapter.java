package com.example.fleetmanagementsystem.driverFunctionality.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;
import com.example.fleetmanagementsystem.driverFunctionality.activities.DriversDetailsActivity;
import com.example.fleetmanagementsystem.Constants.BundleKeys;

import java.util.ArrayList;
import java.util.List;

public class DriversAdapter extends RecyclerView.Adapter<DriversAdapter.DriverViewHolder> {

    private List<DriverModel> driverModels  = new ArrayList<>();
    Context context;

    @NonNull
    @Override
    public DriverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DriverViewHolder driverViewHolder = new DriverViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.driver_item,parent,false));
        this.context = parent.getContext();
        return driverViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DriverViewHolder holder, int position) {
        holder.initDate(driverModels.get(position),context);
    }

    public void setList(List<DriverModel> driverModels){
        this.driverModels = driverModels;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return driverModels.size();
    }

    public class DriverViewHolder extends RecyclerView.ViewHolder{

        TextView driverName, driverLicense, driverNumber;
        CardView driverCard;

        public DriverViewHolder(@NonNull View itemView) {
            super(itemView);

            driverName = itemView.findViewById(R.id.driver_name);
            driverNumber = itemView.findViewById(R.id.driver_number_item);
            driverLicense = itemView.findViewById(R.id.driver_license);
            driverCard = itemView.findViewById(R.id.card_item_driver);
        }
        public void initDate(DriverModel driverModel , Context context){

            driverName.setText(driverModel.getName());
            driverNumber.setText(driverModel.getPhone());

            driverCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,DriversDetailsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(BundleKeys.DRIVER_MODEL_KEY,driverModel);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        }

    }

}
