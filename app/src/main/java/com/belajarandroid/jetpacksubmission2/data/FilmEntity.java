package com.belajarandroid.jetpacksubmission2.data;

public class FilmEntity {
    private String filmId;
    private String filmPoster, filmBackdrop;
    private String filmTitle, filmDate, filmRate, filmGenre, filmLang;
    private String filmOverview, filmPopularity;

    public String getFilmId() {
        return filmId;
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

    public FilmEntity(String filmId, String filmPoster, String filmBackdrop, String filmTitle, String filmDate, String filmRate, String filmGenre, String filmLang, String filmOverview, String filmPopularity) {
        this.filmId = filmId;
        this.filmPoster = filmPoster;
        this.filmBackdrop = filmBackdrop;
        this.filmTitle = filmTitle;
        this.filmDate = filmDate;
        this.filmRate = filmRate;
        this.filmGenre = filmGenre;
        this.filmLang = filmLang;
        this.filmOverview = filmOverview;
        this.filmPopularity = filmPopularity;


    }
}
