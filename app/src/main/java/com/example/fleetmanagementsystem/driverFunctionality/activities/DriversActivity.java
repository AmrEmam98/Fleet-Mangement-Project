package com.example.fleetmanagementsystem.driverFunctionality;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.driverFunctionality.fragment.DriversBusFragment;
import com.example.fleetmanagementsystem.driverFunctionality.fragment.DriversFragment;
import com.example.fleetmanagementsystem.driverFunctionality.fragment.DriversSpareFragment;
import com.example.fleetmanagementsystem.driverFunctionality.fragment.DriversTruckFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class DriversActivity extends AppCompatActivity {

    private FloatingActionButton mainFab , addFab , deleteFab , editFab;

    private Animation fabOpenAnim , fabCloseAnim;

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    DriversFragment driversFragment;
    DriversBusFragment driversBusFragment;
    DriversTruckFragment driversTruckFragment;
    DriversSpareFragment driversSpareFragment ;

    boolean isOpen ;

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



        //ViewPager , TabLayout
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = findViewById(R.id.drivers_view_pager);
        tabLayout = findViewById(R.id.tab_layout);

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
        viewPagerAdapter.addFragment(driversSpareFragment , "Spare");
        viewPager.setAdapter(viewPagerAdapter);

        isOpen = false;

        //Set Animation
        fabOpenAnim = AnimationUtils.loadAnimation(this,R.anim.fab_open);
        fabCloseAnim = AnimationUtils.loadAnimation(this,R.anim.fab_close);
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
}