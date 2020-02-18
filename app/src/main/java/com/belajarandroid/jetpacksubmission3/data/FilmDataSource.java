package com.belajarandroid.jetpacksubmission3.data;

import androidx.lifecycle.LiveData;

import com.belajarandroid.jetpacksubmission3.data.source.local.entity.FilmEntity;
import com.belajarandroid.jetpacksubmission3.vo.Resource;

import java.util.List;

public interface FilmDataSource {
    LiveData<Resource<List<FilmEntity>>> getMovie();

    LiveData<Resource<List<FilmEntity>>> getShow();

    LiveData<List<FilmEntity>> getFavoritedMovie();

    LiveData<List<FilmEntity>> getFavoritedShow();

    LiveData<Resource<FilmEntity>> getDetailMovie(String movieId);

    LiveData<Resource<FilmEntity>> getDetailShow(String showId);

    void setFilmFavorite(FilmEntity entity, boolean state);
}
