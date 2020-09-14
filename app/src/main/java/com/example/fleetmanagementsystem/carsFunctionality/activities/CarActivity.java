package com.example.fleetmanagementsystem.carsFunctionality.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.pojo.carModel;

import java.util.ArrayList;
import java.util.List;

public class CarActivity extends AppCompatActivity {

    private List<carModel> mCarModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        exampleListCreation();

        RecyclerView recyclerView = findViewById(R.id.recycler_car);
        CarsAdapter adapter = new CarsAdapter();
        adapter.setList(mCarModel);
        recyclerView.setLayoutManager(new GridLayoutManager(this , 2));
        recyclerView.setAdapter(adapter);

    }

    public void exampleListCreation(){

        mCarModel = new ArrayList<>();

        mCarModel.add(new carModel("Marcedes" , 2020 , R.drawable.car_image1));
        mCarModel.add(new carModel("BMW" , 2020 , R.drawable.car_image2));
        mCarModel.add(new carModel("Matrix" , 2020 , R.drawable.car_image3));
        mCarModel.add(new carModel("Lancer" , 2020 , R.drawable.car_image4)); mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image1));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image2));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image3));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image4)); mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image1));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image2));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image3));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image4)); mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image1));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image2));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image3));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image4)); mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image1));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image2));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image3));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image4)); mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image1));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image2));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image3));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image4)); mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image1));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image2));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image3));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image4)); mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image1));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image2));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image3));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image4)); mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image1));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image2));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image3));
        mCarModel.add(new carModel("Verna" , 2020 , R.drawable.car_image4));


    }

}