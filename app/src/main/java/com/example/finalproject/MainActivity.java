package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button logout;
  //  private Session session;
    TextView txt;
    private Handler handlernew = new Handler();

//    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
//            new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
//                    Fragment selectedFragment = null;
//
//                    switch (item.getItemId()) {
//                        case R.id.nav_profile:
//                            selectedFragment = new ProfileFragment();
//                            break;
//                        case R.id.nav_characters:
//                            selectedFragment = new CharactersFragment();
//                            break;
//                        case R.id.nav_settings:
//                            selectedFragment = new SettingsFragment();
//                            break;
//                    }
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                            selectedFragment).commit();
//                    return true;
//                }
//            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.firstText);
//        session = new Session(this);
//        if (!session.loggedIn()) {
//            logout();
//        }

//
//         BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
//         bottomNav.setOnNavigationItemSelectedListener(navListener);


        handlernew.postDelayed(new Runnable(){

            @Override
            public void run() {
                try {
                    Intent intent = new Intent(getApplicationContext(),
                            LoginPage.class);
                    startActivity(intent);
                    finish();
                } catch( Exception ignored) {
                    ignored.printStackTrace();
                }
            }
        }, 2000);



    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handlernew.removeCallbacksAndMessages(null);
    }

//    private void logout() {
//        session.setLoggedIn(false);
//        finish();
//        startActivity(new Intent(MainActivity.this, LoginPage.class));
//    }
}




