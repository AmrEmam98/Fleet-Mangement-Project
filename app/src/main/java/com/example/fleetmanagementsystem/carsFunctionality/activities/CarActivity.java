package com.example.fleetmanagementsystem.carsFunctionality.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.pojo.CarModel;

import java.util.List;

public class CarActivity extends AppCompatActivity {

    private List<CarModel> mCarModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        //exampleListCreation();

        RecyclerView recyclerView = findViewById(R.id.recycler_car);
        CarsAdapter adapter = new CarsAdapter();
        adapter.setList(mCarModel);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);

    }

  /*  public void exampleListCreation() {

        mCarModel = new ArrayList<>();

        mCarModel.add(new CarModel("Marcedes", 2020, R.drawable.car_image1));
        mCarModel.add(new CarModel("BMW", 2020, R.drawable.car_image2));
        mCarModel.add(new CarModel("Matrix", 2020, R.drawable.car_image3));
        mCarModel.add(new CarModel("Lancer", 2020, R.drawable.car_image4));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image1));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image2));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image3));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image4));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image1));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image2));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image3));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image4));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image1));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image2));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image3));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image4));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image1));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image2));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image3));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image4));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image1));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image2));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image3));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image4));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image1));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image2));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image3));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image4));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image1));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image2));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image3));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image4));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image1));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image2));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image3));
        mCarModel.add(new CarModel("Verna", 2020, R.drawable.car_image4));


    }*/

}