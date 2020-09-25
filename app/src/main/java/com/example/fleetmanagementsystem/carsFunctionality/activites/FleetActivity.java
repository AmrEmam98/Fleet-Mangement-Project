package com.example.fleetmanagementsystem.carsFunctionality.activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ProgressBar;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.carsFunctionality.adapter.FleetAdapter;
import com.example.fleetmanagementsystem.carsFunctionality.fragment.CarsFragment;
import com.example.fleetmanagementsystem.carsFunctionality.fragment.SpareFragment;
import com.example.fleetmanagementsystem.carsFunctionality.fragment.TruckFragment;
import com.example.fleetmanagementsystem.dataFilter.FleetFilter;
import com.example.fleetmanagementsystem.homeFunctionality.HomeActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class FleetActivity extends AppCompatActivity {

    public FleetFilter fleetFilter;
    ProgressBar bar;
    private ListenFromActivity activityListener;
    private SearchView searchView;
    String searchText;

    public void setActivityListener(ListenFromActivity activityListener) {
        this.activityListener = activityListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fleet);
        //////////////////////////
        fleetFilter=new FleetFilter();

        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        searchView = findViewById(R.id.carsSearch);
        /////////////////////////
        CarsFragment carsFragment = new CarsFragment();
        SpareFragment spareFragment = new SpareFragment();
        TruckFragment vehicleFragment = new TruckFragment();

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(carsFragment, "Cars");
        viewPagerAdapter.addFragment(vehicleFragment, "Buses");
        viewPagerAdapter.addFragment(spareFragment, "Spare");
        viewPager.setAdapter(viewPagerAdapter);

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                searchText = s;
                return false;
            }
        });

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

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        if (null != activityListener) {
            activityListener.doSearchInFragment(searchText);
        }
    }
}