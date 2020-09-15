package com.example.fleetmanagementsystem.carsFunctionality.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.pojo.CarModel;

import java.util.ArrayList;
import java.util.List;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.PostViewHolder> {

    private List<CarModel> carsList = new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.carName.setText(carsList.get(position).getName());
        holder.carModel.setText(carsList.get(position).getModel() + "");
        //holder.carImage.setImageResource(carsList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }

    public void setList(List<CarModel> carsList) {
        this.carsList = carsList;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView carName, carModel;
        ImageView carImage;
        Button carPreview;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            carName = itemView.findViewById(R.id.car_name);
            carModel = itemView.findViewById(R.id.car_model);
            carImage = itemView.findViewById(R.id.car_image);
            carPreview = itemView.findViewById(R.id.btn_review);
        }
    }
}
