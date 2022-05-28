package com.example.finalproject;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CharactersFragment extends Fragment {
    private List<ImagesResponse> imagesResponseList = new ArrayList<>();
    RecyclerView recyclerView;
    List<ImagesResponse>imagesList;
    static ConstraintLayout charactersFragment;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        imagesList = new ArrayList<>();
        charactersFragment = view.findViewById(R.id.CharactersBackground);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.breakingbadapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface imageApi = retrofit.create(ApiInterface.class);
        Call<List<ImagesResponse>> call =  imageApi.getAllImages();

        call.enqueue(new Callback<List<ImagesResponse>>() {

            @Override
            public void onResponse(Call<List<ImagesResponse>> call, Response<List<ImagesResponse>> response) {
                if (response.code() != 200) {
                    return;
                }
                Log.i("sdf", "onFailure: " + response.body().toString());
                List<ImagesResponse> images = response.body();
                PutDataIntoRecyclerView(imagesList);

                for(ImagesResponse image: images) {
                    String k = image.getChar_id();
                    String name = image.getName();
                    String img = image.getImg();
                    System.out.println(k);
                    System.out.println(name);
                    System.out.println(img);
                    imagesList.add(image);


                }

                PutDataIntoRecyclerView(imagesList);
            }



            @Override
            public void onFailure(Call<List<ImagesResponse>> call, Throwable t) {
                Log.i("sdf", "onFailure: " + t.getMessage());
                System.out.println("An error has occured");
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_characters, container, false);
    }

    private void PutDataIntoRecyclerView(List<ImagesResponse> imagesList) {
        ImagesAdapter adaptery = new ImagesAdapter(getContext(), imagesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adaptery);
    }
    public  void changeCharacter() {
        charactersFragment.getViewById(R.id.CharactersBackground);
    }


}




