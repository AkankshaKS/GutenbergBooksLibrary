package com.gutenbergbookslibrary.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gutenbergbookslibrary.R;
import com.gutenbergbookslibrary.databinding.ItemGenreBinding;
import com.gutenbergbookslibrary.model.Genre;

import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.ViewHolder>  {

    private List<Genre> genres;
    private Context mContext;
    ItemGenreBinding binding;

    public GenreAdapter(Context mContext, List<Genre> genresList) {
        this.mContext = mContext;
        this.genres = genresList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.item_genre,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         Genre genre = genres.get(position);
         holder.bind(genre);
    }

    @Override
    public int getItemCount() {
        return genres.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemGenreBinding binding;

        ViewHolder(ItemGenreBinding itemGenreBinding) {
            super(itemGenreBinding.getRoot());
            binding = itemGenreBinding;
        }

        void bind(final Genre genre){
            binding.textGenre.setText(genre.getTitle());
            Glide.with(mContext).load(genre.getThumbnail()).into(binding.iconGenre);
        }

    }

}
