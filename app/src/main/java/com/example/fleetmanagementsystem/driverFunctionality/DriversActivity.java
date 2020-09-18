package com.example.fleetmanagementsystem.driverFunctionality;

import androidx.appcompat.app.AppCompatActivity;
import com.example.fleetmanagementsystem.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class DriversActivity extends AppCompatActivity {

    private FloatingActionButton mainFab , addFab , deleteFab , editFab;
    private Animation fabOpenAnim , fabCloseAnim;
    boolean isOpen ;
    private DriversFragment driversFragment;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drivers);
        setUI();
    }
    public void onFabClicked(View view) {
        if (isOpen){

            addFab.startAnimation(fabCloseAnim);
            deleteFab.startAnimation(fabCloseAnim);
            editFab.startAnimation(fabCloseAnim);

            relativeLayout.setVisibility(View.GONE);

            isOpen = false;

        }else {

            addFab.setVisibility(View.VISIBLE);
            deleteFab.setVisibility(View.VISIBLE);
            editFab.setVisibility(View.VISIBLE);

            addFab.startAnimation(fabOpenAnim);
            deleteFab.startAnimation(fabOpenAnim);
            editFab.startAnimation(fabOpenAnim);

            relativeLayout.setVisibility(View.VISIBLE);

            isOpen = true;
        }
    }
    private void setUI(){

        // Floating Action Buttons
        mainFab = findViewById(R.id.mainFloatingActionBtn);
        addFab = findViewById(R.id.addFloatingActionBtn);
        deleteFab = findViewById(R.id.deleteFloatingActionBtn);
        editFab = findViewById(R.id.editFloatingActionBtn);

        //Relative Layout
        relativeLayout = findViewById(R.id.relative_layout_driver);

        //Set Animation
        fabOpenAnim = AnimationUtils.loadAnimation(this,R.anim.fab_open);
        fabCloseAnim = AnimationUtils.loadAnimation(this,R.anim.fab_close);

    }
}