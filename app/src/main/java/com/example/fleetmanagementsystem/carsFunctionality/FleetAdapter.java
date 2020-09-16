package com.example.fleetmanagementsystem.carsFunctionality;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fleetmanagementsystem.R;

import java.util.ArrayList;
import java.util.List;

public class FleetAdapter extends RecyclerView.Adapter<FleetAdapter.PostViewHolder> {

    private List<FleetModel> carsList = new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.carName.setText(carsList.get(position).getName());
        holder.carModel.setText(carsList.get(position).getModel());
        holder.driverName.setText(carsList.get(position).getDriverId());

        String imageUrl = carsList.get(position).getImage();
        Glide.with(holder.itemView.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.car_icon)
                .into(holder.carImage);

    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }

    public void setList(List<FleetModel> carsList) {
        this.carsList = carsList;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView carName, carModel , driverName;
        ImageView carImage;


        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            carName = itemView.findViewById(R.id.car_name);
            carModel = itemView.findViewById(R.id.car_model);
            carImage = itemView.findViewById(R.id.car_image);
            driverName = itemView.findViewById(R.id.driver_model);

        }
    }
}
