package com.belajarandroid.jetpacksubmission2.data;

public class FilmEntity {
    private String filmId;
    private String filmPoster, filmBackdrop;
    private String filmTitle, filmDate, filmRate, filmGenre, filmLang;
    private String filmOverview, filmPopularity;

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getFilmPoster() {
        return filmPoster;
    }

    public void setFilmPoster(String filmPoster) {
        this.filmPoster = filmPoster;
    }

    public String getFilmBackdrop() {
        return filmBackdrop;
    }

    public void setFilmBackdrop(String filmBackdrop) {
        this.filmBackdrop = filmBackdrop;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getFilmDate() {
        return filmDate;
    }

    public void setFilmDate(String filmDate) {
        this.filmDate = filmDate;
    }

    public String getFilmRate() {
        return filmRate;
    }

    public void setFilmRate(String filmRate) {
        this.filmRate = filmRate;
    }

    public String getFilmGenre() {
        return filmGenre;
    }

    public void setFilmGenre(String filmGenre) {
        this.filmGenre = filmGenre;
    }

    public String getFilmLang() {
        return filmLang;
    }

    public void setFilmLang(String filmLang) {
        this.filmLang = filmLang;
    }

    public String getFilmOverview() {
        return filmOverview;
    }

    public void setFilmOverview(String filmOverview) {
        this.filmOverview = filmOverview;
    }

    public String getFilmPopularity() {
        return filmPopularity;
    }

    public void setFilmPopularity(String filmPopularity) {
        this.filmPopularity = filmPopularity;
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
