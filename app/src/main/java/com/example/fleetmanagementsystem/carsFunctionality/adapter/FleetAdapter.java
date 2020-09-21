package com.example.fleetmanagementsystem.carsFunctionality.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.activites.CarDetailsActivity;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.fleetmanagementsystem.Constants.BundleKeys.FLEET_MODEL_KEY;

public class FleetAdapter extends RecyclerView.Adapter<FleetAdapter.FleetViewHolder> {

    private List<FleetModel> carsList = new ArrayList<>();

    Context context;
    @NonNull
    @Override
    public FleetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FleetViewHolder fleetViewHolder = new FleetViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_item, parent, false));
        context=parent.getContext();
        return fleetViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FleetViewHolder holder, int position) {
        holder.initData(carsList.get(position),context);
    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }

    public void setList(List<FleetModel> carsList) {
        this.carsList = carsList;
        notifyDataSetChanged();
    }

    public class FleetViewHolder extends RecyclerView.ViewHolder  {
        TextView carName, chasissNum, plateNum;
        ImageView carImage;
        CardView cardView;

        public FleetViewHolder(@NonNull View itemView) {
            super(itemView);
            carName = itemView.findViewById(R.id.car_name);
            carImage = itemView.findViewById(R.id.car_image);
            plateNum = itemView.findViewById(R.id.plateNum);
            chasissNum = itemView.findViewById(R.id.chassisNum);
            cardView=itemView.findViewById(R.id.card_item);

        }
        public void initData(FleetModel fleetModel, Context context){
            carName.setText(fleetModel.name);
            chasissNum.setText(fleetModel.chassisNum);
            plateNum.setText(fleetModel.plateNum);
            cardView.setOnClickListener(view -> {
                Intent intent=new Intent(context, CarDetailsActivity.class);
                Bundle bundle= new Bundle();
                bundle.putSerializable(FLEET_MODEL_KEY,fleetModel);
                intent.putExtras(bundle);
                context.startActivity(intent);
            });
        }

    }


}
