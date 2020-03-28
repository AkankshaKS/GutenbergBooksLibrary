package com.gutenbergbookslibrary.viewmodel;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.gutenbergbookslibrary.model.BooksData;
import com.gutenbergbookslibrary.repository.BooksRepository;

public class BooksViewModel extends AndroidViewModel {

    private BooksRepository booksRepository;
    private LiveData<BooksData> booksDataLiveData;


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

    public void getSearchedBooks(String searchedQuery){
        booksRepository.getSearchedBooks(searchedQuery);
    }

    public LiveData<BooksData> getBooksData() {
            return booksDataLiveData;
    }

}
