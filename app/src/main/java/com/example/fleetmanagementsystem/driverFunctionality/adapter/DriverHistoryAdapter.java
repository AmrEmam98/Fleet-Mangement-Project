package com.example.fleetmanagementsystem.driverFunctionality.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleetmanagementsystem.carsFunctionality.models.CarHistoryModel;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverHistoryModel;

import java.util.ArrayList;
import java.util.List;
import com.example.fleetmanagementsystem.R;

public class DriverHistoryAdapter extends RecyclerView.Adapter<DriverHistoryAdapter.DriverHistoryViewHolder> {

    List<DriverHistoryModel> driverHistoryModels  = new ArrayList<>();

    @NonNull
    @Override
    public DriverHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.history_item,parent,false);
        DriverHistoryViewHolder driverHistoryViewHolder = new DriverHistoryViewHolder(view);
        return driverHistoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DriverHistoryViewHolder holder, int position) {
        holder.initData(driverHistoryModels.get(position));
    }

    @Override
    public int getItemCount() {
        return driverHistoryModels.size();
    }

    public void setList(List<DriverHistoryModel> driverHistoryModels){
        this.driverHistoryModels = driverHistoryModels;
        notifyDataSetChanged();
    }

    public class DriverHistoryViewHolder extends RecyclerView.ViewHolder {
        TextView car , startDate , endDate;
        public DriverHistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            initUI(itemView);
        }

        public void initData(DriverHistoryModel driverHistoryModel){
            car.setText(driverHistoryModel.getCarName());
            startDate.setText(driverHistoryModel.getStartDate());
            endDate.setText(driverHistoryModel.getEndDate());
        }

        private void initUI(View view){
            car = itemView.findViewById(R.id.history_driver);
            startDate = itemView.findViewById(R.id.history_start);
            endDate = itemView.findViewById(R.id.history_end);
        }

    }
}
