package com.example.fleetmanagementsystem.carsFunctionality.activites;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.fragment.DeleteDialog;
import com.example.fleetmanagementsystem.carsFunctionality.fragment.EditDialog;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;

import java.util.List;

public class CarDetailsActivity extends AppCompatActivity implements EditDialog.EditeDialogListner {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        textView = findViewById(R.id.maker_subTitle);
    }

    public void openDeleteDialog(View view) {
        DeleteDialog deleteDialog = new DeleteDialog();
        deleteDialog.show(getSupportFragmentManager() , "Edit Dialog");

    }

    public void openEditDialog(View view) {
        EditDialog editDialog = new EditDialog();
        editDialog.show(getSupportFragmentManager() , "Edit Dialog");

    }



    @Override
    public void applyText(String subTitle){
        textView.setText(subTitle);
    }

}