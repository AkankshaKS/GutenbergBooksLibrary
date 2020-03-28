package com.gutenbergbookslibrary.utils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit;
    private static final OkHttpClient client;

    public void ApiClient(){

    }

    public static Retrofit getRetrofitInstance(){

        if(retrofit==null){

            retrofit = new Retrofit.Builder()
                    .baseUrl("http://skunkworks.ignitesol.com:8000")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

        }

        return retrofit;
    }

    static {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);


        client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(new AuthInterceptor())
                .build();
    }
}
