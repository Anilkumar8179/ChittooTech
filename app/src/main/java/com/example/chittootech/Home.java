package com.example.chittootech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.chittootech.fragment.CertificateFragment;
import com.example.chittootech.fragment.ChatFragment;
import com.example.chittootech.fragment.ProfileFragment;
import com.example.chittootech.fragment.ScoreFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        loadFragment(new ProfileFragment());

        BottomNavigationView.OnNavigationItemSelectedListener selectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;

                int id = menuItem.getItemId();

                if (id == R.id.nav_certificate) {
                    selectedFragment = new CertificateFragment();
                } else if (id == R.id.nav_profile) {
                    selectedFragment = new ProfileFragment();
                } else if (id == R.id.nav_chat) {
                    selectedFragment = new ChatFragment();
                } else if (id == R.id.nav_score) {
                    selectedFragment = new ScoreFragment();
                }

                if (selectedFragment != null) {
                    loadFragment(selectedFragment);
                    return true;
                }
                return false;

            }
        };
        bottomNavigationView.setOnNavigationItemSelectedListener(selectedListener);
    }
    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }


}
