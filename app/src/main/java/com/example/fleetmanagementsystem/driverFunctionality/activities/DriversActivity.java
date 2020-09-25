package com.example.fleetmanagementsystem.driverFunctionality.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.dataFilter.DriverFilter;
import com.example.fleetmanagementsystem.driverFunctionality.fragment.DriversBusFragment;
import com.example.fleetmanagementsystem.driverFunctionality.fragment.DriversFragment;
import com.example.fleetmanagementsystem.driverFunctionality.fragment.DriversSpareFragment;
import com.example.fleetmanagementsystem.driverFunctionality.fragment.DriversTruckFragment;
import com.example.fleetmanagementsystem.homeFunctionality.HomeActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class DriversActivity extends AppCompatActivity {

    public DriverFilter driverFilter;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    DriversFragment driversFragment;
    DriversBusFragment driversBusFragment;
    DriversTruckFragment driversTruckFragment;
    DriversSpareFragment driversSpareFragment ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drivers);
        driverFilter = new DriverFilter();
        setUI();
    }

    public void onAddFabDriverClicked(View view) {
        Intent intent = new Intent(this,AddDriverActivity.class);
        startActivity(intent);
    }

    private void setUI(){

        //ViewPager , TabLayout
        toolbar = findViewById(R.id.toolbar_driver);
        setSupportActionBar(toolbar);
        viewPager = findViewById(R.id.drivers_view_pager);
        tabLayout = findViewById(R.id.tab_layout_driver);

        //Fragments
        driversFragment = new DriversFragment();
        driversBusFragment = new DriversBusFragment();
        driversTruckFragment = new DriversTruckFragment();
        driversSpareFragment = new DriversSpareFragment();

        tabLayout.setupWithViewPager(viewPager);

        DriversActivity.ViewPagerAdapter viewPagerAdapter = new DriversActivity.ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(driversFragment , "Cars");
        viewPagerAdapter.addFragment(driversBusFragment , "Bus");
        viewPagerAdapter.addFragment(driversTruckFragment , "Truck");
        viewPagerAdapter.addFragment(driversSpareFragment , "Idle");
        viewPager.setAdapter(viewPagerAdapter);

    }

    public static class ViewPagerAdapter extends FragmentPagerAdapter {

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
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DriversActivity.this, HomeActivity.class));
        finishAffinity();
    }
}