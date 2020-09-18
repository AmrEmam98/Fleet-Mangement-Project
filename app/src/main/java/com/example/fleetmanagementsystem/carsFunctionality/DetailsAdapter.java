package com.example.fleetmanagementsystem.carsFunctionality;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fleetmanagementsystem.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DetailsAdapter  extends RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder> {

    private List<FleetModel> detailsList = new ArrayList<>();
    private DetailsAdapter.onItemClicked onItemClicked;

    public DetailsAdapter(DetailsAdapter.onItemClicked onItemClicked) {
        this.onItemClicked = onItemClicked;
    }

    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DetailsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_details_item, parent, false));
    }

    @NonNull


    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }

    public void setList(List<FleetModel> detailsList) {
        this.detailsList = detailsList;
        notifyDataSetChanged();
    }

    public class DetailsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView detailsTitle, detailsSubTitle;
        ImageView detailsEditImage;

        public DetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            detailsTitle = itemView.findViewById(R.id.details_title);
            detailsEditImage = itemView.findViewById(R.id.details_Edit);
            detailsSubTitle = itemView.findViewById(R.id.details_subTitle);

            detailsEditImage.setOnClickListener(this);
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
