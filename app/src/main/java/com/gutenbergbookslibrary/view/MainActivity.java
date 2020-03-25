package com.gutenbergbookslibrary.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.gutenbergbookslibrary.R;
import com.gutenbergbookslibrary.databinding.ActivityMainBinding;
import com.gutenbergbookslibrary.model.Genre;
import com.gutenbergbookslibrary.view.adapter.BookAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    BookAdapter adapter;
    List<Genre> genreList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        genreList = new ArrayList<>();
        adapter = new BookAdapter(this, genreList);
        prepareGenres();

        LinearLayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(layoutManager);


    }

    private void prepareGenres() {
        int[] icon_genre = new int[]{
                R.drawable.fiction,
                R.drawable.drama,
                R.drawable.humour,
                R.drawable.politics,
                R.drawable.philosophy,
                R.drawable.history,
                R.drawable.adventure};

        Genre genres = new Genre( icon_genre[0],"FICTION");
        genreList.add(genres);

        genres = new Genre( icon_genre[1],"DRAMA");
        genreList.add(genres);

        genres = new Genre( icon_genre[2],"HUMOUR");
        genreList.add(genres);

        genres = new Genre( icon_genre[3],"POLITICS");
        genreList.add(genres);

        genres = new Genre( icon_genre[4],"PHILOSPHY");
        genreList.add(genres);

        genres = new Genre( icon_genre[5],"HISTORY");
        genreList.add(genres);

        genres = new Genre( icon_genre[6],"ADVENTURE");
        genreList.add(genres);

        adapter.notifyDataSetChanged();




    }
}
