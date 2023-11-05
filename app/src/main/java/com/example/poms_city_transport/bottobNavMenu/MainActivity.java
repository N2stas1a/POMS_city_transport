package com.example.poms_city_transport.bottobNavMenu;

import android.os.Bundle;

import com.example.poms_city_transport.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.poms_city_transport.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Заменяем фрагмент по умолчанию (может потребоваться импортировать фрагменты)
        replaceFragment(new HomeFragment());

        BottomNavigationView navView = binding.navView; // Исправляем название переменной

        navView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case 0: // Для R.id.navigation_home
                    replaceFragment(new HomeFragment());
                    break;
                case 1: // Для R.id.navigation_map
                    replaceFragment(new mapFragment());
                    break;
                case 2: // Для R.id.navigation_route
                    replaceFragment(new routeFragment());
                    break;
                case 3: // Для R.id.navigation_bookmarks
                    replaceFragment(new bookmarksFragment());
                    break;
                case 4: // Для R.id.navigation_info
                    replaceFragment(new infoFragment());
                    break;
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

    private void setupNavigation() {
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_adress, R.id.navigation_info,R.id.navigation_routes,R.id.navigation_bookmarks)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }
}