package com.belajarandroid.jetpacksubmission2.data.source;

import androidx.lifecycle.LiveData;

import com.belajarandroid.jetpacksubmission2.data.FilmEntity;

import java.util.List;

public interface FilmDataSource {
    LiveData<List<FilmEntity>> getMovie();

    LiveData<List<FilmEntity>> getShow();

    LiveData<FilmEntity> getDetailMovie(String movieId);

    LiveData<FilmEntity> getDetailShow(String showId);
}
