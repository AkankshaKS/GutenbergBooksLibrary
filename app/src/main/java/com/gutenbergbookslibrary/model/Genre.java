package com.gutenbergbookslibrary.model;

public class Genre {

    private int thumbnail;
    private String title;

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre(int thumbnail, String title) {
        this.thumbnail = thumbnail;
        this.title = title;
    }
}
