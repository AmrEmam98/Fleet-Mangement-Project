package com.example.fleetmanagementsystem.carsFunctionality;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fleetmanagementsystem.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class FleetActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private CarsFragment carsFragment;
    private SpareFragment spareFragment;
    private VehicleFragment vehicleFragment;

    private FloatingActionButton mainFab , addFab , deleteFab , editFab;
    private RelativeLayout relativeLayout;

    private Animation fabOpenAnim , fabCloseAnim;

    boolean isOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fleet);

        mainFab = findViewById(R.id.mainFloatingActionBtn);
        relativeLayout = findViewById(R.id.relative_layout_car);

        addFab = findViewById(R.id.addFloatingActionBtn);
        deleteFab = findViewById(R.id.deleteFloatingActionBtn);
        editFab = findViewById(R.id.editFloatingActionBtn);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        carsFragment = new CarsFragment();
        spareFragment = new SpareFragment();
        vehicleFragment = new VehicleFragment();

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(carsFragment , "Cars");
        viewPagerAdapter.addFragment(vehicleFragment , "Vehicles");
        viewPagerAdapter.addFragment(spareFragment , "Spare");
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.getTabAt(0).setIcon(R.drawable.car);
        tabLayout.getTabAt(1).setIcon(R.drawable.vehicle);
        tabLayout.getTabAt(2).setIcon(R.drawable.spare);

        isOpen = false;

        fabOpenAnim = AnimationUtils.loadAnimation(FleetActivity.this , R.anim.fab_open);
        fabCloseAnim = AnimationUtils.loadAnimation(FleetActivity.this , R.anim.fab_close);

    }

    public void onFabClicked(View view) {

        if (isOpen){

            addFab.startAnimation(fabCloseAnim);
            deleteFab.startAnimation(fabCloseAnim);
            editFab.startAnimation(fabCloseAnim);

            relativeLayout.setVisibility(View.GONE);

            isOpen = false;

        }else {

            addFab.startAnimation(fabOpenAnim);
            deleteFab.startAnimation(fabOpenAnim);
            editFab.startAnimation(fabOpenAnim);

            relativeLayout.setVisibility(View.VISIBLE);

            isOpen = true;
        }
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
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.main_menu , menu);
        return true;
    }


}