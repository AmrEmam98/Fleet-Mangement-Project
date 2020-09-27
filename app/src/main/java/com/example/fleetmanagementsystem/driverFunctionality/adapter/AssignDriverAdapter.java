package com.example.fleetmanagementsystem.driverFunctionality.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleetmanagementsystem.FirebaseServices.RetrieveDataFromFireStore;
import com.example.fleetmanagementsystem.driverFunctionality.fragment.AssignDriverDialog;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;
import com.example.fleetmanagementsystem.dataFilter.FleetFilter;
import com.example.fleetmanagementsystem.driverFunctionality.activities.DriverAssignActivity;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;

import java.util.ArrayList;
import java.util.List;
import com.example.fleetmanagementsystem.R;

public class AssignDriverAdapter extends RecyclerView.Adapter<AssignDriverAdapter.AssignDriverViewHolder> implements Filterable {

    FleetFilter fleetFilter;
    DriverModel currentDriver;
    List<FleetModel> carModels;
    List<FleetModel> carModelsFull;
    Activity context;

    public AssignDriverAdapter(Activity context , DriverModel currentDriver){
        this.context = context;
        this.currentDriver = currentDriver;

        if(RetrieveDataFromFireStore.retrieveCarsCalled) {
            fleetFilter=new FleetFilter();
            this.carModels=fleetFilter.getSpare();
            carModelsFull = new ArrayList<>(carModels);
        }
    }

    @NonNull
    @Override
    public AssignDriverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.assign_car_item, parent, false);
        return new AssignDriverViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AssignDriverViewHolder holder, int position) {
            holder.initData(context,carModels.get(position));
    }

    @Override
    public int getItemCount() {
        return carModels.size();
    }

    public class AssignDriverViewHolder extends RecyclerView.ViewHolder {

        TextView carName , carNumber;
        ImageView carImage , addCarIcon;

        public AssignDriverViewHolder(@NonNull View itemView) {
            super(itemView);
            carName = itemView.findViewById(R.id.assign_car_name);
            carNumber = itemView.findViewById(R.id.assign_car_number);
            carImage = itemView.findViewById(R.id.assign_car_image);
            addCarIcon = itemView.findViewById(R.id.assign_car_icon);
        }

        public void initData(Context context, FleetModel carModel){
            carName.setText(carModel.getName());
            carNumber.setText(carModel.getPlateNum());
            addCarIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AssignDriverDialog assignDriverDialog = new AssignDriverDialog(carModel,currentDriver);
                    assignDriverDialog.show(((DriverAssignActivity)context).getSupportFragmentManager(),"Title Driver");
                }
            });
        }
    }

    @Override
    public Filter getFilter() {
        return searchCarFilter;
    }

    private Filter searchCarFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<FleetModel> filteredList = new ArrayList<>();
            if (charSequence==null || charSequence.length() == 0){
                filteredList.addAll(carModelsFull);
            }else {
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for (FleetModel item: carModelsFull){
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
            carModels.clear();
            carModels.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };
}
