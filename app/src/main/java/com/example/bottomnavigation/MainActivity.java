package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bottomnavigation.Fragment.AccountFragment;
import com.example.bottomnavigation.Fragment.FavoiteFragment;
import com.example.bottomnavigation.Fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // kita set default nya Home Fragment
        loadFragment(new HomeFragment());// inisialisasi BottomNavigaionView
        BottomNavigationView bottomNavigationView = findViewById(R.id.botNav);// beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    // method untuk load fragment yang sesuai
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content, fragment)
                    .commit();
            return true;
        }   return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.home:
                fragment = new HomeFragment();
                break;
            case R.id.favorite:
                fragment = new FavoiteFragment();
                break;
            case R.id.account:
                fragment = new AccountFragment();
                break;
        }
        return loadFragment(fragment);
    }
}