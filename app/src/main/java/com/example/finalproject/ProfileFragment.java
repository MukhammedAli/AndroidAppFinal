package com.example.finalproject;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProfileFragment  extends Fragment  {
    private String user;
    private String date;
    private String fullname;
    ListView listView;
    Context context;
    SaveDataProfile sv;
    DBHelper dbHelper;
    public Date d;
    //Button btnSay;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.listView);
        //btnSay = view.findViewById(R.id.btner);
         sv = RegistrationActivity.getSave();
        List<String> title = new ArrayList<>();
        List<Integer> image = new ArrayList<>();
        List<String> titleOne = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        SharedPreferences sp = getContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        user = sp.getString("user", "");
        fullname = sp.getString("fullname", "");
        date = sp.getString("date", "");

//        String pattern = sdf.format(sv.getDate());





        title.add(user);
        title.add(date);
        title.add(fullname);


        titleOne.add("Your login");
        titleOne.add("Date of registration");
        titleOne.add("Your name");

        image.add(R.drawable.ic_baseline_home_24);
        image.add(R.drawable.ic_baseline_calendar_today_24);
        image.add(R.drawable.ic_baseline_person_24);

        ProfAdapter profAdapter = new ProfAdapter(getContext(), title, image, titleOne);
        listView.setAdapter(profAdapter);

//        btnSay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                fetchData();
//            }
//        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }


//    public void fetchData() {
//
//         Cursor cursor = dbHelper.getData();
//
////         if (cursor.moveToFirst()) {
////             do {
////                String username = cursor.getString(cursor.getColumnIndex(DBHelper.username));
////                 String dateOfEntering = cursor.getString(cursor.getColumnIndex(DBHelper.dateOfEntering));
////                 String fullname = cursor.getString(cursor.getColumnIndex(DBHelper.fullname));
////                 Log.i("DATABASE_TAG","username" + username + "dateofentering" + dateOfEntering + "fullname" + fullname);
////             } while (cursor.moveToNext());
////         }
////        while (cursor.moveToNext()) {
////            if (cursor.getString(1).equals(username))
////        }
//    }


}
