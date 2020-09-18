package com.example.fleetmanagementsystem.carsFunctionality.activites;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.models.FleetModel;

import java.util.List;

public class CarDetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

    }

    public void editCar(View view) {
        switch (view.getId()) {
            case R.id.maker_Edit:
               Toast.makeText(this , "Maker Edit" , Toast.LENGTH_LONG).show();
                break;
            case R.id.license_Edit:
                Toast.makeText(this , "Lincese Edit" , Toast.LENGTH_LONG).show();
                break;
            case R.id.chassis_Edit:
                Toast.makeText(this , "Chassis Edit" , Toast.LENGTH_LONG).show();
                break;
                // TODO Handle each edit attribute
            default:
                break;
        }
    }
}