package com.belajarandroid.jetpacksubmission1.data;

public class FilmEntity {
    private String filmId, filmType;
    private String filmPoster, filmBackdrop;
    private String filmTitle, filmDate, filmRate, filmPopularity, filmGenre, filmOverview, filmRuntime;
    private String filmStatus, filmBudget, filmRevenue, filmAdult;

    public FilmEntity(String filmId, String filmType, String filmPoster, String filmBackdrop, String filmTitle, String filmDate, String filmRate, String filmPopularity, String filmGenre, String filmOverview, String filmRuntime, String filmStatus, String filmBudget, String filmRevenue, String filmAdult) {
        this.filmId = filmId;
        this.filmType = filmType;
        this.filmPoster = filmPoster;
        this.filmBackdrop = filmBackdrop;
        this.filmTitle = filmTitle;
        this.filmDate = filmDate;
        this.filmRate = filmRate;
        this.filmPopularity = filmPopularity;
        this.filmGenre = filmGenre;
        this.filmOverview = filmOverview;
        this.filmRuntime = filmRuntime;
        this.filmStatus = filmStatus;
        this.filmBudget = filmBudget;
        this.filmRevenue = filmRevenue;
        this.filmAdult = filmAdult;
    }

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

    public String getFilmPopularity() {
        return filmPopularity;
    }

    public String getFilmGenre() {
        return filmGenre;
    }

    public String getFilmOverview() {
        return filmOverview;
    }

    public String getFilmRuntime() {
        return filmRuntime;
    }

    public String getFilmStatus() {
        return filmStatus;
    }

    public String getFilmBudget() {
        return filmBudget;
    }

    public String getFilmRevenue() {
        return filmRevenue;
    }

    public String getFilmAdult() {
        return filmAdult;
    }
}
