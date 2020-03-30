package com.gutenbergbookslibrary.view;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BooksActivity extends AppCompatActivity {

    ActivityBooksBinding binding;
    BookAdapter adapter;
    List<Result> resultArrayList = new ArrayList<>();
    List<Result> pagedArrayList = new ArrayList<>();
    BooksViewModel viewModel;
    String genre;
    int page;
    Uri uri;
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
            if(data.getNext() != null){
                uri = Uri.parse(data.getNext());
                String pageNumber = uri.getQueryParameter("page");
                Log.d("page", pageNumber);
                page = Integer.parseInt(pageNumber);
                getPagedBooksData(page);


            }
           if(isFirst){
               for(int i = 0; i < data.getResults().size(); i++){
                   if(data.getResults().get(i).getFormats().getImageJpeg() != null){
                       Result result = data.getResults().get(i);
                       resultArrayList.add(result);
                   }else if(resultArrayList == null){
                       getPagedBooksData(page);
                   }
               }

           }else if(!isEmpty && !isFirst){
               getPagedBooksData(page);

            }

            adapter.setAdapter(resultArrayList);
            adapter.notifyDataSetChanged();
        });
    }

    private void getPagedBooksData(int page) {


        viewModel.getGenrePagedBooks(String.valueOf(page), genre);

        viewModel.getPagedBooksData().observe(this, data -> {

            if(data.getNext() != null){
                for(int i = 0; i < data.getResults().size(); i++){
                    if(data.getResults().get(i).getFormats().getImageJpeg() != null){
                        Result result = data.getResults().get(i);
                        pagedArrayList.add(result);
                    }
                }
            }

            adapter.setAdapter(pagedArrayList);
            adapter.notifyDataSetChanged();

            if(data.getNext() != null){
                uri = Uri.parse(data.getNext());
                String pageNumber = uri.getQueryParameter("page");
                Log.d("page", pageNumber);
                 int paged = Integer.parseInt(pageNumber);
                getPagedBooksData(paged);
            }else{
                Toast.makeText(getApplicationContext(), "That's all", Toast.LENGTH_LONG).show();
            }
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
                    if( page != 0){
                        getPagedBooksData(page);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(), "Loading.. please wait", Toast.LENGTH_LONG).show();
                    }

                }
                super.onScrollStateChanged(recyclerView, newState);
            }
        });

    }

    private void getGenreBooks(String genre) {
      viewModel.getGenreBooks(genre);
    }



}
