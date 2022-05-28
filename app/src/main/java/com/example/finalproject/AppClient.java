//package com.example.finalproject;
//
//import okhttp3.OkHttpClient;
//import okhttp3.logging.HttpLoggingInterceptor;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class AppClient {
//
//    private static Retrofit getRetrofit() {
//
//        HttpLoggingInterceptor httpLoggingInterceptor = new  HttpLoggingInterceptor();
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(httpLoggingInterceptor)
//                .build();
//
//        Retrofit retrofit =  new Retrofit.Builder()
//                .baseUrl("hhttps://run.mocky.io/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClient)
//                .build();
//
//
//        return retrofit;
//    }
//
//    public static ApiInterface getInterface() {
//        ApiInterface apiInterface = getRetrofit().create(ApiInterface.class);
//        return apiInterface;
//    }
//}
//
//
