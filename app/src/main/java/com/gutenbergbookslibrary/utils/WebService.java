package com.gutenbergbookslibrary.utils;

import com.gutenbergbookslibrary.model.BooksData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebService {

    @GET("/books")
    Call<BooksData> getGenreBooks(@Query("topic") String genre);

    @GET("/books")
    Call<BooksData> getGenrePagedBooks(@Query("page") String page,
                                        @Query("topic") String genre);

    @GET("/books")
    Call<BooksData> getSearchedBooks(@Query("search") String searchQuery);



}
