package com.gutenbergbookslibrary.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
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
    List<Result> pagedArrayList = new ArrayList<>();
    BooksViewModel viewModel;
    String genre;
    boolean isFirst, isLast, isEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_books);
        viewModel = ViewModelProviders.of(this).get(BooksViewModel.class);
        viewModel.init();
        genre = getIntent().getStringExtra("genre");
        getGenreBooks(genre);
        binding.textGenre.setText(genre);
        setAdapter();
        initSearchView();
        binding.iconBack.setOnClickListener(v -> BooksActivity.super.onBackPressed());


        viewModel.getBooksData().observe(this, data -> {

           checkForData(data);
           if(isFirst){
               for(int i = 0; i < data.getResults().size(); i++){
                   if(data.getResults().get(i).getFormats().getImageJpeg() != null){
                       Result result = data.getResults().get(i);
                       resultArrayList.add(result);
                   }
               }
           }else if(!isEmpty && !isFirst){
               getPagedBooksData();

            }

            adapter.setAdapter(resultArrayList);
            adapter.notifyDataSetChanged();
        });
    }

    private void getPagedBooksData() {

        int i = 6;
        viewModel.getGenrePagedBooks(String.valueOf(i), genre);

        viewModel.getPagedBooksData().observe(this, data -> {
            for(int i1 = 0; i1 < data.getResults().size(); i1++){
                if(data.getResults().get(i1).getFormats().getImageJpeg() != null){
                    Result result = data.getResults().get(i1);
                    pagedArrayList.add(result);
                }
            }
            adapter.setAdapter(pagedArrayList);
            adapter.notifyDataSetChanged();
        });

    }

    private void checkForData(BooksData data) {

        if(data.getPrevious() == null && data.getNext() != null){
            isFirst = true;
            isLast = false;
        }else if(data.getNext() == null && data.getPrevious() != null){
            isFirst = false;
            isLast = true;
        }else if(data.getPrevious() == null && data.getNext() == null){
            isEmpty = true;
        }
    }


    private void initSearchView() {

        binding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String searchQuery) {

                viewModel.getSearchedBooks(searchQuery);
                binding.search.clearFocus();
                adapter.notifyDataSetChanged();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }



    private void setAdapter() {

        adapter = new BookAdapter(this);
        final GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(layoutManager);

        binding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {

                if(!binding.recyclerView.canScrollVertically(1)){
                    while (isFirst){
                        getPagedBooksData();
                        isFirst = false;
                        adapter.notifyDataSetChanged();


                    }
                    Toast.makeText(getApplicationContext(), "Loading..please wait", Toast.LENGTH_LONG).show();
                }
                super.onScrollStateChanged(recyclerView, newState);
            }
        });

    }

    private void getGenreBooks(String genre) {
      viewModel.getGenreBooks(genre);

    }


}
