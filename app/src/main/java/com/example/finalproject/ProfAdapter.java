package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ProfAdapter extends ArrayAdapter {

    List<String> titleOne;
    List<String> listTitle;
    List<Integer> imageList;
    Context context;

    public ProfAdapter(@NonNull Context context, List<String> title, List<Integer> image, List<String> titleOne) {
        super(context, R.layout.items_prof, title);
        this.titleOne = titleOne;
        this.listTitle = title;
        this.imageList = image;
        this.context = context;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.items_prof,parent,false);
         ImageView imageView = view.findViewById(R.id.iconFirst);
         TextView textView = view.findViewById(R.id.textView);
         TextView textTitle = view.findViewById(R.id.titleTextone);
         textView.setText(listTitle.get(position));
         imageView.setImageResource(imageList.get(position));
         textTitle.setText(titleOne.get(position));

         return view;

        //return super.getView(position, convertView, parent);
    }
}

