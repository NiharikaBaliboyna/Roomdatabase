package com.example.lenovo.roomdatabase.roomdatabase;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class FavoriteMovies {
    @PrimaryKey(autoGenerate = true)
    int mvieId;

    String title;
    String poster;
    String desc;
    Float rating;

    public int getMvieId() {
        return mvieId;
    }

    public void setMvieId(int mvieId) {
        this.mvieId = mvieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
