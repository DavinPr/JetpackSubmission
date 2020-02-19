package com.belajarandroid.jetpacksubmission3.data;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.belajarandroid.jetpacksubmission3.data.source.local.entity.FilmEntity;
import com.belajarandroid.jetpacksubmission3.vo.Resource;

public interface FilmDataSource {
    LiveData<Resource<PagedList<FilmEntity>>> getMovie();

    LiveData<Resource<PagedList<FilmEntity>>> getShow();

    LiveData<PagedList<FilmEntity>> getFavoritedMovie();

    LiveData<PagedList<FilmEntity>> getFavoritedShow();

    LiveData<Resource<FilmEntity>> getDetailMovie(String movieId);

    LiveData<Resource<FilmEntity>> getDetailShow(String showId);

    void setFilmFavorite(FilmEntity entity, boolean state);
}
