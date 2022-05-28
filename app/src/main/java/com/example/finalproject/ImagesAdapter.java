package com.example.finalproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.MyViewHolder>{

    private  Context iContext;
    private List<ImagesResponse> imagesList;

    public ImagesAdapter(Context iContext, List<ImagesResponse> imagesList) {
        this.iContext = iContext;
        this.imagesList = imagesList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(iContext);
        v = layoutInflater.inflate(R.layout.fragment_characters_temp, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            holder.birthday.setText(imagesList.get(position).getBirthday());
            holder.name.setText(imagesList.get(position).getName());
        Glide.with(iContext)
                .load(imagesList.get(position).getImg())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        TextView birthday;
        TextView name;
        //TextView char_id;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            birthday = itemView.findViewById(R.id.textView2);
            name = itemView.findViewById(R.id.textView1);
            img = itemView.findViewById(R.id.imageView);
        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();
            ImagesResponse imagesItem = imagesList.get(position);

            Intent intent = new Intent(iContext, CharacterDetails.class);
           // intent.putExtra("imageResource", imagesItem.getImg());
            intent.putExtra("name",  imagesList.get(position));
            iContext.startActivity(intent);
        }
    }
//    private ArrayList<ImagesResponse> images;
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//    private ArrayList<ImagesResponse> intiCities() {
//        ArrayList<ImagesResponse> list = new ArrayList<>();
//        list.add(new ImagesResponse(12,"John", "https://images.amcnetworks.com/amc.com/wp-content/uploads/2015/04/cast_bb_700x1000_walter-white-lg.jpg"));
//        list.add(new ImagesResponse(13,"Peter", "https://images.amcnetworks.com/amc.com/wp-content/uploads/2015/04/cast_bb_700x1000_walter-white-lg.jpg"));
//        list.add(new ImagesResponse(14,"Michael", "https://images.amcnetworks.com/amc.com/wp-content/uploads/2015/04/cast_bb_700x1000_walter-white-lg.jpg"));
//    }
}
















