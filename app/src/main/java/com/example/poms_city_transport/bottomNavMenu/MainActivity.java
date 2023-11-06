package com.example.poms_city_transport.bottomNavMenu;

import android.os.Bundle;

import com.example.poms_city_transport.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.poms_city_transport.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());

        BottomNavigationView navView = binding.navView;

        navView.setOnItemSelectedListener(item -> {
            int selectedItemId = item.getItemId();
            if (selectedItemId == R.id.navigation_home) {
                replaceFragment(new HomeFragment());
            } else if (selectedItemId == R.id.navigation_route) {
                replaceFragment(new routeFragment());
            } else if (selectedItemId == R.id.navigation_bookmarks) {
                replaceFragment(new bookmarksFragment());
            } else if (selectedItemId == R.id.navigation_info) {
                replaceFragment(new infoFragment());
            } else if (selectedItemId == R.id.navigation_userdashboard) {
                replaceFragment(new userdashboardFragment());
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, fragment);
        fragmentTransaction.commit();
    }
}