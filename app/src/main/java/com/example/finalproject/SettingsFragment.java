package com.example.finalproject;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class SettingsFragment extends Fragment {

    RelativeLayout SettingsFragment;
    ListView lv;
    List<String>options;
    Context context;
    Button btnLogOut;
    Session session;
    static int checker = 0;
    static SharedPreferences shf;
    Button logoutSettings;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        session = new Session(getContext());


        shf = this.getActivity().getSharedPreferences("GetColor",Context.MODE_PRIVATE);
        btnLogOut = view.findViewById(R.id.logoutsettings);
        lv = view.findViewById(R.id.listViewSettings);
        SettingsFragment = view.findViewById(R.id.SettingsFragment);
        options =  new ArrayList<>();
        options.add("Change background");
        options.add("Select option share");
        ConstraintLayout constraintLayout = view.findViewById(R.id.CharactersBackground);
        SettingAdapter setAdapter = new SettingAdapter(getContext(), options);
        lv.setAdapter(setAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        checker++;
                        SharedPreferences.Editor editor = shf.edit();
                        editor.putString("blue_accent", "blue_accent");
                        editor.putInt("checker", checker);
                        editor.apply();
                        Intent intentone = new Intent(getContext(), MainProjectPage.class);
                        startActivity(intentone);
                        break;
                    case 1: Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    String body = "Download this app";
                    String sub = "http://play.google.com";
                    intent.putExtra(Intent.EXTRA_TEXT, body);
                    intent.putExtra(Intent.EXTRA_TEXT, sub);
                    startActivity(Intent.createChooser(intent, "Share using"));
                    break;

                }

            }
        });
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    private void logout() {
        session.setLoggedIn(false);
        startActivity(new Intent(this.getContext(), LoginPage.class));
    }
}


















