package com.belajarandroid.jetpacksubmission3.data.source;

import androidx.lifecycle.LiveData;

import com.belajarandroid.jetpacksubmission3.data.FilmEntity;

import java.util.List;

public interface FilmDataSource {
    LiveData<List<FilmEntity>> getMovie();

    LiveData<List<FilmEntity>> getShow();

    LiveData<FilmEntity> getDetailMovie(String movieId);

    LiveData<FilmEntity> getDetailShow(String showId);
}
