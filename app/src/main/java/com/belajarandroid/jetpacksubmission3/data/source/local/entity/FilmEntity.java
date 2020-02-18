package com.belajarandroid.jetpacksubmission3.data.source.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "filmentities")
public class FilmEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "filmId")
    private String filmId;
    @ColumnInfo(name = "filmType")
    private String filmType;
    @ColumnInfo(name = "filmPoster")
    private String filmPoster;
    @ColumnInfo(name = "filmBackdrop")
    private String filmBackdrop;
    @ColumnInfo(name = "filmTitle")
    private String filmTitle;
    @ColumnInfo(name = "filmDate")
    private String filmDate;
    @ColumnInfo(name = "filmRate")
    private String filmRate;
    @ColumnInfo(name = "filmGenre")
    private String filmGenre;
    @ColumnInfo(name = "filmLang")
    private String filmLang;
    @ColumnInfo(name = "filmOverview")
    private String filmOverview;
    @ColumnInfo(name = "filmPopularity")
    private String filmPopularity;
    @ColumnInfo(name = "favorited")
    private boolean favorited = false;

    public String getFilmId() {
        return filmId;
    }

    public String getFilmType() {
        return filmType;
    }

    public String getFilmPoster() {
        return filmPoster;
    }

    public String getFilmBackdrop() {
        return filmBackdrop;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public String getFilmDate() {
        return filmDate;
    }

    public String getFilmRate() {
        return filmRate;
    }

    public String getFilmGenre() {
        return filmGenre;
    }

    public String getFilmOverview() {
        return filmOverview;
    }

    public String getFilmPopularity() {
        return filmPopularity;
    }

    public String getFilmLang() {
        return filmLang;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public FilmEntity(String filmId,
                      String filmType,
                      String filmPoster,
                      String filmBackdrop,
                      String filmTitle,
                      String filmDate,
                      String filmRate,
                      String filmGenre,
                      String filmLang,
                      String filmOverview,
                      String filmPopularity,
                      Boolean favorited) {
        this.filmId = filmId;
        this.filmType = filmType;
        this.filmPoster = filmPoster;
        this.filmBackdrop = filmBackdrop;
        this.filmTitle = filmTitle;
        this.filmDate = filmDate;
        this.filmRate = filmRate;
        this.filmGenre = filmGenre;
        this.filmLang = filmLang;
        this.filmOverview = filmOverview;
        this.filmPopularity = filmPopularity;
        if (favorited != null){
            this.favorited = favorited;
        }
    }
}
