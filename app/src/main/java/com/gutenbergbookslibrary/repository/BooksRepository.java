package com.gutenbergbookslibrary.repository;

import com.gutenbergbookslibrary.utils.AppExecutors;
import com.gutenbergbookslibrary.utils.WebService;

public class BooksRepository {

    WebService webService;
    private final AppExecutors appExecutors;
    private static final int PAGE_SIZE = 20;
    private static volatile BooksRepository sInstance;


    public BooksRepository(WebService movieService,
                           AppExecutors executors) {
        webService = movieService;
        appExecutors = executors;
    }



}
