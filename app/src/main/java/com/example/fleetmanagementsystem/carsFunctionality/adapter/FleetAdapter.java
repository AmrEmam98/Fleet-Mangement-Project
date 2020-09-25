package com.example.fleetmanagementsystem.carsFunctionality.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.SearchView;
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

public class FleetAdapter extends RecyclerView.Adapter<FleetAdapter.FleetViewHolder> implements Filterable {

    private List<FleetModel> carsList = new ArrayList<>();
    private List<FleetModel> carsListFull;
    int vehicleImage;


    public FleetAdapter(int vehicleImage) {
        this.vehicleImage = vehicleImage;
    }

    Context context;
    @SuppressLint("CheckResult")
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
        this.carsList.clear();
        this.carsList = carsList;
        carsListFull = new ArrayList<>(carsList);
        notifyDataSetChanged();
    }



    public class FleetViewHolder extends RecyclerView.ViewHolder  {
        TextView carName, chasissNum, plateNum;
        ImageView vehicleImageView;
        CardView cardView;

        public FleetViewHolder(@NonNull View itemView) {
            super(itemView);
            carName = itemView.findViewById(R.id.driver_number);
            vehicleImageView = itemView.findViewById(R.id.car_image);
            plateNum = itemView.findViewById(R.id.plateNum);
            chasissNum = itemView.findViewById(R.id.chassisNum);
            cardView=itemView.findViewById(R.id.card_item);

        }
        public void initData(FleetModel fleetModel, Context context){
            vehicleImageView.setImageResource(vehicleImage);
            carName.setText(fleetModel.name);
            chasissNum.setText(fleetModel.chassisNum);
            plateNum.setText(fleetModel.plateNum);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, CarDetailsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(FLEET_MODEL_KEY, fleetModel);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        }

    }

    @Override
    public Filter getFilter() {
        return vehicleFilter;
    }

    private Filter vehicleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<FleetModel> filteredList = new ArrayList<>();
            if (charSequence==null || charSequence.length() == 0){
                filteredList.addAll(carsListFull);
            }else {
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for (FleetModel item: carsListFull){
                    if (item.getPlateNum().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            carsList.clear();
            carsList.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };


}
