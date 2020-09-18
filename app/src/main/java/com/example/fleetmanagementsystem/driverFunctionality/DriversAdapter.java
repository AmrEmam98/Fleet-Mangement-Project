package com.example.fleetmanagementsystem.driverFunctionality;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fleetmanagementsystem.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DriversAdapter extends RecyclerView.Adapter<DriversAdapter.DriverViewHolder> {

    private List<DriverModel> driverModels  = new ArrayList<>();
    private onItemClicked onItemClicked;
    public DriversAdapter(DriversAdapter.onItemClicked onItemClicked){
        this.onItemClicked = onItemClicked;
    }

    @NonNull
    @Override
    public DriverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DriverViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.driver_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DriverViewHolder holder, int position) {

    }

    public void setList(List<DriverModel> driverModels){
        this.driverModels = driverModels;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return driverModels.size();
    }

    public class DriverViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView driverImage;
        TextView driverName, driverLicense, carName;

        public DriverViewHolder(@NonNull View itemView) {
            super(itemView);

            driverImage = itemView.findViewById(R.id.driver_image);
            driverName = itemView.findViewById(R.id.driver_name);
            driverLicense = itemView.findViewById(R.id.driver_license);
            carName = itemView.findViewById(R.id.car_name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClicked.onItemClicked(getAdapterPosition());
        }

    }
    public interface onItemClicked{
        void onItemClicked(int postion);
    }
}
