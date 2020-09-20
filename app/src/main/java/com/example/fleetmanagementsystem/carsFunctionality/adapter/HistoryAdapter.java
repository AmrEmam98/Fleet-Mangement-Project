package com.example.fleetmanagementsystem.carsFunctionality.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private List<DriverModel> driverList = new ArrayList<>();

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistoryAdapter.HistoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
            holder.driver.setText("Driver Name");
            holder.startDate.setText("Start Date: 15/10/2017");
            holder.endDate.setText("End Date: 15/7/2020");

    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public void setList(List<DriverModel> driverList) {
        this.driverList = driverList;
        notifyDataSetChanged();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder{
        TextView driver , startDate , endDate;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            driver = itemView.findViewById(R.id.history_driver);
            startDate = itemView.findViewById(R.id.history_start);
            endDate = itemView.findViewById(R.id.history_end);

        }
    }
}

