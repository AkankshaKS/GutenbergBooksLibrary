package com.gutenbergbookslibrary.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("authors")
    @Expose
    private List<Author> authors = null;
    @SerializedName("bookshelves")
    @Expose
    private List<String> bookshelves = null;
    @SerializedName("download_count")
    @Expose
    private Integer downloadCount;
    @SerializedName("formats")
    @Expose
    private Formats formats;
    @SerializedName("languages")
    @Expose
    private List<String> languages = null;
    @SerializedName("media_type")
    @Expose
    private String mediaType;
    @SerializedName("subjects")
    @Expose
    private List<String> subjects = null;
    @SerializedName("title")
    @Expose
    private String title;

    public final static Parcelable.Creator<Result> CREATOR = new Creator<Result>() {

        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        public Result[] newArray(int size) {
            return (new Result[size]);
        }

    };

    protected Result(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.authors, (Author.class.getClassLoader()));
        in.readList(this.bookshelves, (java.lang.String.class.getClassLoader()));
        this.downloadCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.formats = ((Formats) in.readValue((Formats.class.getClassLoader())));
        in.readList(this.languages, (java.lang.String.class.getClassLoader()));
        this.mediaType = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.subjects, (java.lang.String.class.getClassLoader()));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Result() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<String> getBookshelves() {
        return bookshelves;
    }

    public void setBookshelves(List<String> bookshelves) {
        this.bookshelves = bookshelves;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Formats getFormats() {
        return formats;
    }

    public void setFormats(Formats formats) {
        this.formats = formats;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeList(authors);
        dest.writeList(bookshelves);
        dest.writeValue(downloadCount);
        dest.writeValue(formats);
        dest.writeList(languages);
        dest.writeValue(mediaType);
        dest.writeList(subjects);
        dest.writeValue(title);
    }

    public int describeContents() {
        return 0;
    }

}