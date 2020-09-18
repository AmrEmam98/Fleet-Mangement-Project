package com.example.fleetmanagementsystem.carsFunctionality;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleetmanagementsystem.R;

import java.util.ArrayList;
import java.util.List;

public class FleetAdapter extends RecyclerView.Adapter<FleetAdapter.FleetViewHolder> {

    private List<FleetModel> carsList = new ArrayList<>();
    private onItemClicked onItemClicked;

    public FleetAdapter(FleetAdapter.onItemClicked onItemClicked) {
        this.onItemClicked = onItemClicked;
    }

    @NonNull
    @Override
    public FleetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FleetViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FleetViewHolder holder, int position) {
        // holder.carName.setText(carsList.get(position).getName());
        // holder.driverName.setText(carsList.get(position).getDriverId());

        /*String imageUrl = carsList.get(position).getImage();
        Glide.with(holder.itemView.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.car_icon)
                .into(holder.carImage);
*/
    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }

    public void setList(List<FleetModel> carsList) {
        this.carsList = carsList;
        notifyDataSetChanged();
    }

    public class FleetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView carName, carLicense, driverName;
        ImageView carImage;

        public FleetViewHolder(@NonNull View itemView) {
            super(itemView);
            carName = itemView.findViewById(R.id.car_name);
            carImage = itemView.findViewById(R.id.car_image);
            driverName = itemView.findViewById(R.id.driver_name);
            carLicense = itemView.findViewById(R.id.car_license);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClicked.onItemClicked(getAdapterPosition());
        }
    }

    public interface onItemClicked {
        void onItemClicked(int position);
    }

}
