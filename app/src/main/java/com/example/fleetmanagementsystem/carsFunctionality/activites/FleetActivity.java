package com.example.fleetmanagementsystem.carsFunctionality.activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
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
import com.example.fleetmanagementsystem.carsFunctionality.fragment.BusFragment;
import com.example.fleetmanagementsystem.carsFunctionality.fragment.CarsFragment;
import com.example.fleetmanagementsystem.carsFunctionality.fragment.SpareFragment;
import com.example.fleetmanagementsystem.carsFunctionality.fragment.TruckFragment;
import com.example.fleetmanagementsystem.dataFilter.FleetFilter;
import com.example.fleetmanagementsystem.homeFunctionality.HomeActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.subjects.PublishSubject;

public class FleetActivity extends AppCompatActivity {
    public static PublishSubject<String> fleetActivityRefresher=PublishSubject.create();
    public FleetFilter fleetFilter;
    ProgressBar bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fleet);
        //////////////////////////
        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        /////////////////////////
        CarsFragment carsFragment = new CarsFragment();
        SpareFragment spareFragment = new SpareFragment();
        TruckFragment truckFragment = new TruckFragment();
        BusFragment busFragment = new BusFragment();

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(carsFragment, "Cars");
        viewPagerAdapter.addFragment(busFragment, "Buses");
        viewPagerAdapter.addFragment(truckFragment, "Truck");
        viewPagerAdapter.addFragment(spareFragment, "Spare");
        viewPager.setAdapter(viewPagerAdapter);
           }

    public void onAddFabClicked(View view) {

        Intent addIntent = new Intent(this , AddCarActivity.class);
        startActivity(addIntent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        fleetFilter=new FleetFilter();
        Log.d("RESUME","Fleet Activity Resume");
        super.onResume();
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(FleetActivity.this, HomeActivity.class));
        finishAffinity();
    }

    public void openSearchActivity(View view) {
        startActivity(new Intent(FleetActivity.this, CarSearchActivity.class));
    }

    public void finishFleetActivity(View view) {
        startActivity(new Intent(FleetActivity.this, HomeActivity.class));
        finishAffinity();
    }


}