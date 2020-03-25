package com.gutenbergbookslibrary.utils;

import com.gutenbergbookslibrary.model.BooksData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebService {

    @GET("?topic=")
    Call<BooksData> getGenreBooks(@Query("page") int page);

    @GET("?search=")
    Call<BooksData> getSearchedBooks(@Query("page") int page);


}
