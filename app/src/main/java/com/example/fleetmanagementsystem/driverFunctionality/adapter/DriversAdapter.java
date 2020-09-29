package com.example.fleetmanagementsystem.driverFunctionality.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleetmanagementsystem.Constants.BundleKeys;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.driverFunctionality.activities.DriversDetailsActivity;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;

import java.util.ArrayList;
import java.util.List;

public class DriversAdapter extends RecyclerView.Adapter<DriversAdapter.DriverViewHolder> implements Filterable {

    private List<DriverModel> driverModels  = new ArrayList<>();
    private List<DriverModel> driverModelsFull  = new ArrayList<>();
    int driverImage;
    Context context;

    public DriversAdapter(int driverImage){
        this.driverImage = driverImage;
    }

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
        this.driverModels =new ArrayList<>( driverModels);
        this.driverModelsFull =new ArrayList<>( driverModels);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return driverModels.size();
    }

    public class DriverViewHolder extends RecyclerView.ViewHolder{

        TextView driverName, driverType, driverNumber;
        CardView driverCard;
        ImageView driverImageView;

        public DriverViewHolder(@NonNull View itemView) {
            super(itemView);

            driverImageView = itemView.findViewById(R.id.driver_image);
            driverName = itemView.findViewById(R.id.driver_name);
            driverNumber = itemView.findViewById(R.id.driver_number_item);
            driverType = itemView.findViewById(R.id.driver_type);
            driverCard = itemView.findViewById(R.id.card_item_driver);
        }
        public void initDate(DriverModel driverModel , Context context){
            driverImageView.setImageResource(driverImage);
            driverName.setText(driverModel.getName());
            driverNumber.setText(driverModel.getPhone());
            driverType.setText(driverModel.getType());
            driverCard.setOnClickListener(view -> {
                Intent intent = new Intent(context,DriversDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(BundleKeys.DRIVER_MODEL_KEY,driverModel);
                bundle.putInt("DRIVER_IMAGE" , driverImage);
                intent.putExtras(bundle);
                context.startActivity(intent);
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
            List<DriverModel> filteredList = new ArrayList<>();
            if (charSequence==null || charSequence.length() == 0){
                filteredList.addAll(driverModelsFull);
            }else {
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for (DriverModel item: driverModelsFull){
                    if (item.getName().toLowerCase().contains(filterPattern)){
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
            driverModels.clear();
            driverModels.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };


}
