package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class success extends AppCompatActivity {
    private Handler handlernewone = new Handler();
    LottieAnimationView lottie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        lottie = (LottieAnimationView)findViewById(R.id.lottienew);

        lottie.animate();
        handlernewone.postDelayed(new Runnable(){

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
        }, 5000);
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        handlernewone.removeCallbacksAndMessages(null);
    }

}