package com.gutenbergbookslibrary.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.gutenbergbookslibrary.R;
import com.gutenbergbookslibrary.databinding.ActivityMainBinding;
import com.gutenbergbookslibrary.model.Genre;
import com.gutenbergbookslibrary.view.adapter.GenreAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    GenreAdapter adapter;
    List<Genre> genreList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        genreList = new ArrayList<>();
        adapter = new GenreAdapter(this, genreList);
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

        Genre genres = new Genre( icon_genre[0],"fiction");
        genreList.add(genres);

        genres = new Genre( icon_genre[1],"drama");
        genreList.add(genres);

        genres = new Genre( icon_genre[2],"humour");
        genreList.add(genres);

        genres = new Genre( icon_genre[3],"politics");
        genreList.add(genres);

        genres = new Genre( icon_genre[4],"philosphy");
        genreList.add(genres);

        genres = new Genre( icon_genre[5],"history");
        genreList.add(genres);

        genres = new Genre( icon_genre[6],"adventure");
        genreList.add(genres);

        adapter.notifyDataSetChanged();


    }
}
