package com.gutenbergbookslibrary.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gutenbergbookslibrary.model.BooksData;
import com.gutenbergbookslibrary.utils.ApiClient;
import com.gutenbergbookslibrary.utils.WebService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BooksRepository {

    WebService webService;
    private MutableLiveData<BooksData> booksDataMutableLiveData;
    private static final int PAGE_SIZE = 20;


    public BooksRepository() {
        webService = ApiClient.getRetrofitInstance().create(WebService.class);
    }


    public void getGenreBooks(String genre) {

        webService.getGenreBooks(genre).enqueue(new Callback<BooksData>() {
            @Override
            public void onResponse(Call<BooksData> call, Response<BooksData> response) {
                booksDataMutableLiveData.postValue(response.body());
                Log.d("data",response.toString());
            }

            @Override
            public void onFailure(Call<BooksData> call, Throwable t) {
                booksDataMutableLiveData.postValue(null);

            }

        });

    }

    public LiveData<BooksData> getBooksData() {
        return booksDataMutableLiveData;
    }







}
