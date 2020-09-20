package com.example.fleetmanagementsystem.carsFunctionality.activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.fragment.DeleteDialog;

public class CarDetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

    }

    public void openDeleteDialog(View view) {
        DeleteDialog deleteDialog = new DeleteDialog();
        deleteDialog.show(getSupportFragmentManager() , "Delete Dialog");

    }

    public void showHistory(View view) {
        Intent historyIntent = new Intent(this , CarHistoryActivity.class);
        startActivity(historyIntent);
    }

    public void editCar(View view) {
        Intent editIntent = new Intent(this , EditCarActivity.class);
        startActivity(editIntent);
    }
}