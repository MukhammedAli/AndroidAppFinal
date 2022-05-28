package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SettingAdapter extends ArrayAdapter {

    List<String>options;
    Context context;

    public SettingAdapter(@NonNull Context context, List<String>options) {
        super(context, R.layout.items_settings, options);
        this.options = options;
        this.context = context;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.items_settings,parent,false);
        TextView textView = view.findViewById(R.id.settingFirstTitle);
        textView.setText(options.get(position));
        return view;
    }
}
