package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class CharacterDetails extends AppCompatActivity {
    ImagesResponse imagesResponse = null;
    TextView status;
    TextView name;
    TextView birthday;
    TextView occupation;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_details);




        Intent intent = getIntent();
        final Object object = getIntent().getSerializableExtra("name");
        if (object instanceof ImagesResponse) {
           // name.setText(intent.getStringExtra("name"));
//            img.setImageURI(intent.get);
            imagesResponse = (ImagesResponse) object;
        }
         name = findViewById(R.id.textViewDetails1);
         img = findViewById(R.id.imageViewDetails);
         birthday = findViewById(R.id.textViewDetails2);
         occupation = findViewById(R.id.textViewDetails3);
         status = findViewById(R.id.textViewDetails4);
        if (imagesResponse != null) {
            Glide.with(getApplicationContext()).load(imagesResponse.getImg()).into(img);
            name.setText(imagesResponse.getName());
            birthday.setText(imagesResponse.getBirthday());
            occupation.setText(returnOccupation(imagesResponse.getOccupation()));
            status.setText(imagesResponse.getStatus());
        }
    }
    public static String returnOccupation(String[] occupation) {
        String hold = "";
        for (int i = 0; i < occupation.length; i++) {
            if (i == occupation.length - 1)
                hold += occupation[i];
            else
                hold += occupation[i] + " , ";
        }
        return hold;
    }
}




