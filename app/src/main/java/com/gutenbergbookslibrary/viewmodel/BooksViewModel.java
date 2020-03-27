package com.gutenbergbookslibrary.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.gutenbergbookslibrary.model.BooksData;
import com.gutenbergbookslibrary.repository.BooksRepository;
import com.gutenbergbookslibrary.utils.AppExecutors;
import com.gutenbergbookslibrary.utils.WebService;

public class BooksViewModel extends AndroidViewModel {

    private BooksRepository booksRepository;
    Context context;
    public LiveData<BooksData> booksDataLiveData;



    public BooksViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(){
        booksRepository = new BooksRepository();
        booksDataLiveData = booksRepository.getBooksData();

    }
    public void getGenreBooks(String genre) {
        booksRepository.getGenreBooks(genre);
    }

    public LiveData<BooksData> getBooksData() {
            return booksDataLiveData;
    }

}
