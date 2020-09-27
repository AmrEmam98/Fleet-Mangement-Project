package com.example.fleetmanagementsystem.carsFunctionality.adapter;

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
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.activites.AssignActivity;
import com.example.fleetmanagementsystem.carsFunctionality.fragment.AssignDialog;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;
import com.example.fleetmanagementsystem.dataFilter.DriverFilter;
import com.example.fleetmanagementsystem.driverFunctionality.models.DriverModel;

import java.util.ArrayList;
import java.util.List;

public class AssignAdapter extends RecyclerView.Adapter<AssignAdapter.AssignViewHolder> implements Filterable {
    // implements Filterable

    DriverFilter driverFilter;
    FleetModel currentFleet;
    List<DriverModel>driverModels;
    List<DriverModel> driverModelsFull;
    public Activity context;

    public AssignAdapter(Activity context, FleetModel currentFleet) {
        this.context=context;
        this.currentFleet=currentFleet;

        if(RetrieveDataFromFireStore.retrieveDriversCalled) {
            driverFilter=new DriverFilter();
            this.driverModels=driverFilter.getSpare();
            driverModelsFull = new ArrayList<>(driverModels);
        }
    }

    @NonNull
    @Override
    public AssignViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       AssignViewHolder assignViewHolder = new AssignViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.assign_driver_item, parent, false));
        return assignViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AssignViewHolder holder, int position) {
        holder.initData(context,driverModels.get(position));
    }

    @Override
    public int getItemCount() {
        return driverModels.size();
    }

    public class AssignViewHolder extends RecyclerView.ViewHolder {

        TextView driverName , driverPhone;
        ImageView driverImage , addDriverIcon;

        public AssignViewHolder(@NonNull View itemView) {
            super(itemView);
            driverName = itemView.findViewById(R.id.driver_name_assign);
            driverPhone = itemView.findViewById(R.id.driver_assign_phone);
            driverImage = itemView.findViewById(R.id.assign_driver_image);
            addDriverIcon = itemView.findViewById(R.id.assign_driver_icon);
        }

        public void initData(Context context,DriverModel driverModel){
            driverPhone.setText(driverModel.getPhone());
            driverName.setText(driverModel.getName());
        addDriverIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   AssignDialog assignDialog =new AssignDialog(currentFleet,driverModel);
                   assignDialog.show(((AssignActivity)context).getSupportFragmentManager(),"Title");
                }
            });
        }
    }

    @Override
    public Filter getFilter() {
        return searchdriverFilter;
    }

    private Filter searchdriverFilter = new Filter() {
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
