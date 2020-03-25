package com.gutenbergbookslibrary.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Author implements Parcelable {

    @SerializedName("birth_year")
    @Expose
    private Integer birthYear;
    @SerializedName("death_year")
    @Expose
    private Integer deathYear;
    @SerializedName("name")
    @Expose
    private String name;

    public final static Parcelable.Creator<Author> CREATOR = new Creator<Author>() {


        public Author createFromParcel(Parcel in) {
            return new Author(in);
        }

        public Author[] newArray(int size) {
            return (new Author[size]);
        }

    };

    protected Author(Parcel in) {
        this.birthYear = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.deathYear = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Author() {
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(birthYear);
        dest.writeValue(deathYear);
        dest.writeValue(name);
    }

    public int describeContents() {
        return 0;
    }

}
