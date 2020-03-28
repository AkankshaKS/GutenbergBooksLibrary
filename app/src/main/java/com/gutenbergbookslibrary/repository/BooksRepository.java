package com.gutenbergbookslibrary.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gutenbergbookslibrary.model.BooksData;
import com.gutenbergbookslibrary.utils.ApiClient;
import com.gutenbergbookslibrary.utils.WebService;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BooksRepository {

    private WebService webService;
    private final MutableLiveData<BooksData> booksDataMutableLiveData = new MutableLiveData<>();
    private final MutableLiveData<BooksData> pagedBooksDataMutableLiveData = new MutableLiveData<>();


    public BooksRepository() {
        webService = ApiClient.getRetrofitInstance().create(WebService.class);
    }


    public void getGenreBooks(String genre) {

        webService.getGenreBooks(genre).enqueue(new Callback<BooksData>() {
            @Override
            public void onResponse(@NotNull Call<BooksData> call, @NotNull Response<BooksData> response) {
                booksDataMutableLiveData.postValue(response.body());
                assert response.body() != null;
            }

            @Override
            public void onFailure(@NotNull Call<BooksData> call, @NotNull Throwable t) {
                booksDataMutableLiveData.postValue(null);

            }

        });

    }

    public void getSearchedBooks(String searchQuery){

        webService.getSearchedBooks(searchQuery).enqueue(new Callback<BooksData>() {
            @Override
            public void onResponse(@NotNull Call<BooksData> call, @NotNull Response<BooksData> response) {

                booksDataMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<BooksData> call, @NotNull Throwable t) {
                booksDataMutableLiveData.postValue(null);

            }
        });
    }


    public void getGenrePagedBooks(String page, String genre){

     webService.getGenrePagedBooks(page, genre).enqueue(new Callback<BooksData>() {
         @Override
         public void onResponse(@NotNull Call<BooksData> call, @NotNull Response<BooksData> response) {

             pagedBooksDataMutableLiveData.postValue(response.body());
         }

         @Override
         public void onFailure(@NotNull Call<BooksData> call, @NotNull Throwable t) {
             pagedBooksDataMutableLiveData.postValue(null);

         }
     });


    }

    public LiveData<BooksData> getBooksData() {
        return booksDataMutableLiveData;
    }

    public LiveData<BooksData> getPagedBooksData() {
        return pagedBooksDataMutableLiveData;
    }


}
