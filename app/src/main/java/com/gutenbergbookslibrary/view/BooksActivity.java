package com.gutenbergbookslibrary.view;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gutenbergbookslibrary.R;
import com.gutenbergbookslibrary.databinding.ActivityBooksBinding;
import com.gutenbergbookslibrary.model.BooksData;
import com.gutenbergbookslibrary.model.Result;
import com.gutenbergbookslibrary.utils.OnBottomReachedListener;
import com.gutenbergbookslibrary.view.adapter.BookAdapter;
import com.gutenbergbookslibrary.viewmodel.BooksViewModel;

import java.util.ArrayList;
import java.util.List;

public class BooksActivity extends AppCompatActivity {

    ActivityBooksBinding binding;
    BookAdapter adapter;
    List<Result> resultArrayList = new ArrayList<>();
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
        binding.textGenre.setText(genre);
        setAdapter();
        initSearchView();

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

    private void initSearchView() {

        binding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String searchQuery) {

                viewModel.getSearchedBooks(searchQuery);
                binding.search.clearFocus();
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


                  //  mMainActivityViewModel.searchNextPage();
                }
                super.onScrollStateChanged(recyclerView, newState);
            }
        });

       /* adapter.setOnBottomReachedListener(new OnBottomReachedListener() {
            @Override
            public void onBottomReached(int position) {
                Log.i("ssss", "enddd");
                Toast.makeText(getApplicationContext(), "END REACHEDD", Toast.LENGTH_LONG).show();
            }
        });*/



    }

    private void getGenreBooks(String genre) {
      viewModel.getGenreBooks(genre);

    }



}
