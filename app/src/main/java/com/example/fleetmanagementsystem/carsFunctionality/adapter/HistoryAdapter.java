package com.example.fleetmanagementsystem.carsFunctionality.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.models.CarHistoryModel;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private List<CarHistoryModel> carHistoryModelList = new ArrayList<>();

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistoryAdapter.HistoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
          holder.initData(carHistoryModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return carHistoryModelList.size();
    }

    public void setList(List<CarHistoryModel> carHistoryModels) {
        this.carHistoryModelList = carHistoryModels;
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
        public void initData(CarHistoryModel carHistoryModel){
            driver.setText(carHistoryModel.getDriverName());
            startDate.setText(carHistoryModel.getStartDate());
            endDate.setText(carHistoryModel.getEndDate());
        }
    }
}

