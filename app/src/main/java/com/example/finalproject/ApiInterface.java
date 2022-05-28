package com.example.finalproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("api/characters")
    Call<List<ImagesResponse>> getAllImages();
}



