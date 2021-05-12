package com.example.provesm7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private final int PERMISSIONS_REQUEST_POSITION = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView btnNav = findViewById(R.id.bottom_navigation);
        btnNav.setOnNavigationItemSelectedListener(navListener);

        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST_POSITION);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "S'ha de donar permís per utilitzar la localització", Toast.LENGTH_LONG).show();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new FundacioFragment()).commit();
        // Linea per afegir registres a la base de dades     startActivity(new Intent(this,DBActivity.class));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch(item.getItemId()){
                        case R.id.imgFundacio:
                            selectedFragment = new FundacioFragment();
                            break;
                        case R.id.imgArtistes:
                            selectedFragment = new ArtistaFragment();
                            break;
                        case R.id.imgMapa:
                            selectedFragment = new MapsActivity();
                            break;
                        case R.id.imgEscultures:
                            selectedFragment = new EsculturaFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,
                            selectedFragment).commit();

                    return true;
                }
            };
}