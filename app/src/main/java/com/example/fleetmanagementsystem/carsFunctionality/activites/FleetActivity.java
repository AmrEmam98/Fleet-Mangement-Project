package com.example.fleetmanagementsystem.carsFunctionality.activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.fragment.CarsFragment;
import com.example.fleetmanagementsystem.carsFunctionality.fragment.SpareFragment;
import com.example.fleetmanagementsystem.carsFunctionality.fragment.VehicleFragment;
import com.example.fleetmanagementsystem.dataFilter.FleetFilter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class FleetActivity extends AppCompatActivity {

    public FleetFilter fleetFilter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private CarsFragment carsFragment;
    private SpareFragment spareFragment;
    private VehicleFragment vehicleFragment;
    ProgressBar bar;


    boolean isOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fleet);
        fleetFilter=new FleetFilter();
        //////////////////////////
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        /////////////////////////
        carsFragment = new CarsFragment();
        spareFragment = new SpareFragment();
        vehicleFragment = new VehicleFragment();
        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(carsFragment , "Cars");
        viewPagerAdapter.addFragment(vehicleFragment , "Vehicles");
        viewPagerAdapter.addFragment(spareFragment , "Spare");
        viewPager.setAdapter(viewPagerAdapter);

        /*tabLayout.getTabAt(0).setIcon(R.drawable.car);
        tabLayout.getTabAt(0).getIcon().setTint(Color.parseColor("#f39b6a"));
        tabLayout.getTabAt(1).setIcon(R.drawable.vehicle);
        tabLayout.getTabAt(1).getIcon().setTint(Color.parseColor("#72d2c4"));
        tabLayout.getTabAt(2).setIcon(R.drawable.spare);
        tabLayout.getTabAt(2).getIcon().setTint(Color.parseColor("#e9666a"));
         */


    }

    public void onAddFabClicked(View view) {

        Intent addIntent = new Intent(this , AddCarActivity.class);
        startActivity(addIntent);

    }


    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTitle = new ArrayList<>();


        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public void addFragment(Fragment fragment , String title){
            fragments.add(fragment);
            fragmentTitle.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }
    }

}