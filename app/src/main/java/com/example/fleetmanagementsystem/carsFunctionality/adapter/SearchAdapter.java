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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleetmanagementsystem.FirebaseServices.RetrieveDataFromFireStore;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.activites.CarDetailsActivity;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.fleetmanagementsystem.Constants.BundleKeys.FLEET_MODEL_KEY;




    public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> implements Filterable {

        private List<FleetModel> carsList = new ArrayList<>();
        private List<FleetModel> carsListFull;
        int vehicleImage;


        public SearchAdapter(int vehicleImage) {
            this.vehicleImage = vehicleImage;
            setList();
        }

        Context context;
        @SuppressLint("CheckResult")
        @NonNull
        @Override
        public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            SearchViewHolder fleetViewHolder = new SearchViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_item, parent, false));
            context=parent.getContext();

            return fleetViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
            holder.initData(carsList.get(position),context);
        }



        @Override
        public int getItemCount() {
            return carsList.size();
        }

        @SuppressLint("CheckResult")
        public void setList() {

            RetrieveDataFromFireStore.carsSubject.subscribe(fleetModels -> {
                this.carsList=new ArrayList<>(fleetModels);
                carsListFull = new ArrayList<>(carsList);
                notifyDataSetChanged();

                    }
            );
        }


        public class SearchViewHolder extends RecyclerView.ViewHolder  {
            TextView carName, fleetType, plateNum;
            ImageView vehicleImageView;
            CardView cardView;

            public SearchViewHolder(@NonNull View itemView) {
                super(itemView);
                carName = itemView.findViewById(R.id.car_name);
                vehicleImageView = itemView.findViewById(R.id.car_image);
                plateNum = itemView.findViewById(R.id.plateNum);
                fleetType = itemView.findViewById(R.id.fleetType);
                cardView=itemView.findViewById(R.id.card_item);

            }
            public void initData(FleetModel fleetModel, Context context){
                vehicleImageView.setImageResource(vehicleImage);
                carName.setText(fleetModel.name);
                fleetType.setText(fleetModel.type);
                plateNum.setText(fleetModel.plateNum);
                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, CarDetailsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(FLEET_MODEL_KEY, fleetModel);
                        bundle.putInt("CAR_IMAGE" , vehicleImage);
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
