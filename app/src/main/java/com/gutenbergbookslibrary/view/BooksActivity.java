package com.gutenbergbookslibrary.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.gutenbergbookslibrary.R;
import com.gutenbergbookslibrary.databinding.ActivityBooksBinding;
import com.gutenbergbookslibrary.model.BooksData;
import com.gutenbergbookslibrary.model.Genre;
import com.gutenbergbookslibrary.view.adapter.BookAdapter;
import com.gutenbergbookslibrary.viewmodel.BooksViewModel;

import java.util.ArrayList;
import java.util.List;

public class BooksActivity extends AppCompatActivity {

    ActivityBooksBinding binding;
    BookAdapter adapter;
    List<Genre> genreList = new ArrayList<>();
    BooksViewModel viewModel;
    String genre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_books);
        viewModel = ViewModelProviders.of(this).get(BooksViewModel.class);
        viewModel.init();
        genre = getIntent().getStringExtra("genre");

        getGenreBooks(genre);

/*
        viewModel.booksDataLiveData.observe(this, new Observer<BooksData>() {
            @Override
            public void onChanged(BooksData booksData) {

                // adapter.setGenreBooks(booksData.getResults().)
            }
        });
*/
    }

    private void getGenreBooks(String genre) {

      viewModel.getGenreBooks(genre);

    }



}
