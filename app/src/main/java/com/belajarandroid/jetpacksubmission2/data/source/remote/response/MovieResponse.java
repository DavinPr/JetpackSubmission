package com.belajarandroid.jetpacksubmission2.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieResponse implements Parcelable {
    private String movieId;
    private String moviePoster, movieBackdrop;
    private String movieTitle, movieDate, movieRate, movieGenre, movieLang;
    private String movieOverview, moviePopularity;

    public MovieResponse() {
    }

    public MovieResponse(String movieId, String moviePoster, String movieBackdrop, String movieTitle, String movieDate, String movieRate, String movieGenre, String movieLang, String movieOverview, String moviePopularity) {
        this.movieId = movieId;
        this.moviePoster = moviePoster;
        this.movieBackdrop = movieBackdrop;
        this.movieTitle = movieTitle;
        this.movieDate = movieDate;
        this.movieRate = movieRate;
        this.movieGenre = movieGenre;
        this.movieLang = movieLang;
        this.movieOverview = movieOverview;
        this.moviePopularity = moviePopularity;
    }

    private MovieResponse(Parcel in) {
        movieId = in.readString();
        moviePoster = in.readString();
        movieBackdrop = in.readString();
        movieTitle = in.readString();
        movieDate = in.readString();
        movieRate = in.readString();
        movieGenre = in.readString();
        movieLang = in.readString();
        movieOverview = in.readString();
        moviePopularity = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(movieId);
        dest.writeString(moviePoster);
        dest.writeString(movieBackdrop);
        dest.writeString(movieTitle);
        dest.writeString(movieDate);
        dest.writeString(movieRate);
        dest.writeString(movieGenre);
        dest.writeString(movieLang);
        dest.writeString(movieOverview);
        dest.writeString(moviePopularity);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MovieResponse> CREATOR = new Creator<MovieResponse>() {
        @Override
        public MovieResponse createFromParcel(Parcel in) {
            return new MovieResponse(in);
        }

        @Override
        public MovieResponse[] newArray(int size) {
            return new MovieResponse[size];
        }
    };

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }

    public String getMovieBackdrop() {
        return movieBackdrop;
    }

    public void setMovieBackdrop(String movieBackdrop) {
        this.movieBackdrop = movieBackdrop;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public String getMovieRate() {
        return movieRate;
    }

    public void setMovieRate(String movieRate) {
        this.movieRate = movieRate;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieLang() {
        return movieLang;
    }

    public void setMovieLang(String movieLang) {
        this.movieLang = movieLang;
    }

    public String getMovieOverview() {
        return movieOverview;
    }

    public void setMovieOverview(String movieOverview) {
        this.movieOverview = movieOverview;
    }

    public String getMoviePopularity() {
        return moviePopularity;
    }

    public void setMoviePopularity(String moviePopularity) {
        this.moviePopularity = moviePopularity;
    }
}
