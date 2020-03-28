package com.gutenbergbookslibrary.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gutenbergbookslibrary.R;
import com.gutenbergbookslibrary.databinding.ActivityBooksBinding;
import com.gutenbergbookslibrary.model.BooksData;
import com.gutenbergbookslibrary.model.Result;
import com.gutenbergbookslibrary.view.adapter.BookAdapter;
import com.gutenbergbookslibrary.viewmodel.BooksViewModel;

import java.util.ArrayList;
import java.util.List;

public class BooksActivity extends AppCompatActivity {

    ActivityBooksBinding binding;
    BookAdapter adapter;
    List<Result> resultArrayList = new ArrayList<>();
    BooksViewModel viewModel;
    String genre, mimetype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_books);
        viewModel = ViewModelProviders.of(this).get(BooksViewModel.class);
        viewModel.init();
        genre = getIntent().getStringExtra("genre");
        mimetype = "text";
        getGenreBooks(genre);
        adapter = new BookAdapter(this);

        binding.textGenre.setText(genre);
        final GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(layoutManager);


        viewModel.getBooksData().observe(this, data -> {

            for(int i = 0; i < data.getResults().size(); i++){
                if(data.getResults().get(i).getFormats().getImageJpeg() != null){
                    Result result = data.getResults().get(i);
                    resultArrayList.add(result);
                }
            }

            adapter.setAdapter(resultArrayList);
        });
    }

    private void getGenreBooks(String genre) {
      viewModel.getGenreBooks(genre);

    }



}
