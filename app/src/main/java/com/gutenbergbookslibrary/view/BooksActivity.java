package com.gutenbergbookslibrary.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.gutenbergbookslibrary.R;
import com.gutenbergbookslibrary.databinding.ActivityBooksBinding;
import com.gutenbergbookslibrary.model.Genre;
import com.gutenbergbookslibrary.view.adapter.GenreAdapter;

import java.util.ArrayList;
import java.util.List;

public class BooksActivity extends AppCompatActivity {

    ActivityBooksBinding binding;
    GenreAdapter adapter;
    List<Genre> genreList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_books);

    }

}
