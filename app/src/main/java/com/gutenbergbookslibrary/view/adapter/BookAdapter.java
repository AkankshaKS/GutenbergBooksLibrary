package com.gutenbergbookslibrary.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gutenbergbookslibrary.R;
import com.gutenbergbookslibrary.databinding.ListItemBooksBinding;
import com.gutenbergbookslibrary.model.Result;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BooksViewHolder> {

    private List<Result> resultList = new ArrayList<>();
    private Context context;


    public BookAdapter(Context context) {
        this.context = context;

    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemBooksBinding binding = DataBindingUtil.inflate(
                layoutInflater, R.layout.list_item_books, parent, false);
        return new BooksViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        Result result = resultList.get(position);
        holder.bind(result, position);



    }

    public void setAdapter(List<Result> results) {
        resultList.addAll(results);
        notifyDataSetChanged();
    }



    @Override
    public int getItemCount() {
        return resultList.size();
    }


    class BooksViewHolder extends RecyclerView.ViewHolder {

        ListItemBooksBinding binding;

        BooksViewHolder(ListItemBooksBinding listItemBooksBinding) {
            super(listItemBooksBinding.getRoot());
            binding = listItemBooksBinding;
        }

        void bind(Result result, int position) {
            Glide.with(context).load(result.getFormats()
                    .getImageJpeg())
                    .into(binding.imageMoviePoster);
            binding.textBookName.setText(result.getTitle());
        //    binding.textBookWriter .setText(result.getAuthors().get(position).getName());
            binding.setBooks(result);

        }

    }
}
