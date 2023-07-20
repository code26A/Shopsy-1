package com.example.shopsy.home;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.shopsy.R;
import com.example.shopsy.databinding.ActivityHomeBinding;
import com.example.shopsy.home.ui.home.HomeFragment;
import com.example.shopsy.loginregister.Login;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomeBinding binding;
    private DrawerLayout mNavDrawer;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Find and set the Toolbar
        Toolbar toolbar = binding.appBarHome.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Find and set the DrawerLayout
        mNavDrawer = binding.drawerLayout;

        // Find and set the NavigationView
        NavigationView navigationView = binding.navView;
        navigationView.setNavigationItemSelectedListener(this);

        // Set up the ActionBar with NavigationUI
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(mNavDrawer)
                .build();
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Set the MenuItem click listener on the Toolbar
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.search_icon) {
                    // Handle search_icon menu item selection
                    // Add your custom logic here
                    return true;
                } else if (id == R.id.notification_icon) {
                    // Handle notification_icon menu item selection
                    // Add your custom logic here
                    return true;
                } else if (id == R.id.cart_white_icon) {
                    // Handle cart_white_icon menu item selection
                    // Add your custom logic here
                    return true;
                }
                // Handle other menu item selections if needed

                return false;
            }
        });
        frameLayout=findViewById(R.id.nav_host_fragment_content_home);
        setFragment(new HomeFragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_orders) {
            // Handle nav_orders item selection
            // Add your custom logic here
        } else if (id == R.id.nav_cart) {
            // Handle nav_cart item selection
            // Add your custom logic here
        } else if (id == R.id.nav_wishlist) {
            // Handle nav_wishlist item selection
            // Add your custom logic here
        } else if (id == R.id.nav_exit) {
            // Handle nav_exit item selection
            // Add your custom logic here
        }

        mNavDrawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),fragment).commit();
    }
}
