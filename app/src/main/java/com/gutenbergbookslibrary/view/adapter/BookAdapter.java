package com.gutenbergbookslibrary.view.adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gutenbergbookslibrary.R;
import com.gutenbergbookslibrary.databinding.ListItemBooksBinding;
import com.gutenbergbookslibrary.model.Result;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
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
        resultList.clear();
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

            binding.cardViewBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(result.getFormats().getTextHtml() != null){
                        openFile(new File(result.getFormats().getTextHtml()));
                    }else if(result.getFormats().getApplicationPdf() != null){
                        openFile(new File(result.getFormats().getApplicationPdf()));

                    }else if(result.getFormats().getTextPlain() != null){
                        openFile(new File(result.getFormats().getTextPlain()));
                    }else{
                        Toast.makeText(context, "NO APP TO DISPLAY",Toast.LENGTH_LONG).show();
                    }

                }
            });

        }

    }

    public void openFile(File url) {

        try {
            Uri uri = FileProvider.getUriForFile(
                    context, context.getPackageName() + ".provider", url);
            Intent intent = new Intent(Intent.ACTION_VIEW);

            if (url.toString().contains(".doc") || url.toString().contains(".docx")) {
                // Word document
                intent.setDataAndType(uri, "application/msword");
            } else if (url.toString().contains(".pdf")) {
                // PDF file
                intent.setDataAndType(uri, "application/pdf");
            } else if (url.toString().contains(".ppt") || url.toString().contains(".pptx")) {
                // Powerpoint file
                intent.setDataAndType(uri, "application/vnd.ms-powerpoint");
            } else if (url.toString().contains(".xls") || url.toString().contains(".xlsx")) {
                // Excel file
                intent.setDataAndType(uri, "application/vnd.ms-excel");
            } else if (url.toString().contains(".zip")) {
                // ZIP file
                intent.setDataAndType(uri, "application/zip");
            } else if (url.toString().contains(".rar")){
                // RAR file
                intent.setDataAndType(uri, "application/x-rar-compressed");
            } else if (url.toString().contains(".rtf")) {
                // RTF file
                intent.setDataAndType(uri, "application/rtf");
            } else if (url.toString().contains(".wav") || url.toString().contains(".mp3")) {
                // WAV audio file
                intent.setDataAndType(uri, "audio/x-wav");
            } else if (url.toString().contains(".gif")) {
                // GIF file
                intent.setDataAndType(uri, "image/gif");
            } else if (url.toString().contains(".jpg") || url.toString().contains(".jpeg") || url.toString().contains(".png")) {
                // JPG file
                intent.setDataAndType(uri, "image/jpeg");
            } else if (url.toString().contains(".txt")) {
                // Text file
                intent.setDataAndType(uri, "text/plain");
            } else if (url.toString().contains(".3gp") || url.toString().contains(".mpg") ||
                    url.toString().contains(".mpeg") || url.toString().contains(".mpe") || url.toString().contains(".mp4") || url.toString().contains(".avi")) {
                // Video files
                intent.setDataAndType(uri, "video/*");
            } else {
                intent.setDataAndType(uri, "*/*");
            }
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, "No application found which can open the file", Toast.LENGTH_SHORT).show();
        }
    }
}
