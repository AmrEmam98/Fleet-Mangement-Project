package com.example.fleetmanagementsystem.carsFunctionality.activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.fragment.DeleteDialog;
import com.example.fleetmanagementsystem.carsFunctionality.fragment.EditDialog;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;

import java.util.List;

public class CarDetailsActivity extends AppCompatActivity implements EditDialog.EditeDialogListner {

    TextView textView;
    View currentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        textView = findViewById(R.id.maker_subTitle);
    }

    public void openDeleteDialog() {
        DeleteDialog deleteDialog = new DeleteDialog();
        deleteDialog.show(getSupportFragmentManager() , "Delete Dialog");

    }

    public void openEditDialog(View view) {
        EditDialog editDialog = new EditDialog();
        currentView=view;
        editDialog.show(getSupportFragmentManager() , "Edit Dialog");

    }


    @Override
    public void applyText(String subTitle){
        //TODO Swith case
        switch (currentView.getId())
        {
            case R.id.maker_Edit:
                //set data in pojo
                textView.setText(subTitle);
        }

        //Edit.editFleet(fleetmodle)
    }

    public void showHistory(View view) {
        Intent historyIntent = new Intent(this , CarHistoryActivity.class);
        startActivity(historyIntent);
    }
}