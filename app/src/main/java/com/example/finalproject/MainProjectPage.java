package com.example.finalproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainProjectPage extends AppCompatActivity {
//    private List<ImagesResponse> imagesResponseList = new ArrayList<>();
//    RecyclerView recyclerView;
//    List<ImagesResponse>imagesList;

    //LinearLayout newLinear;
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
//                        case R.id.nav_settings2:
//                            selectedFragment = new SettingsFragmentNew();
//                            break;
                        case R.id.nav_profile:
                            selectedFragment = new ProfileFragment();
                            break;
                        case R.id.nav_characters:
                            selectedFragment = new CharactersFragment();
                            break;
                        case R.id.nav_settings:
                            selectedFragment = new SettingsFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
    //public Retrofit retrofit = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        recyclerView = findViewById(R.id.recyclerView);
//        imagesList = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_project_page);
        FrameLayout fl = findViewById(R.id.fragment_container);


        SharedPreferences sp = getSharedPreferences("GetColor", Context.MODE_PRIVATE);
        String colorone = sp.getString("blue_accent","blue_accent");
        int numberone = sp.getInt("checker",0);

        if (colorone.equals("blue_accent") && numberone % 2 == 0){
            fl.setBackgroundResource(R.color.blue_accent);
        } else {
            fl.setBackgroundResource(R.color.white);
        }


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        bottomNav.setSelectedItemId(R.id.nav_characters);
    }

    }



















