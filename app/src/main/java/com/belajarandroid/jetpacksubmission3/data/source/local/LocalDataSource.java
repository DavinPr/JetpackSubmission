package com.belajarandroid.jetpacksubmission3.data.source.local;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import com.belajarandroid.jetpacksubmission3.data.source.local.entity.FilmEntity;
import com.belajarandroid.jetpacksubmission3.data.source.local.room.FilmDao;

import java.util.List;

public class LocalDataSource {
    private static LocalDataSource INSTANCE;
    private final FilmDao filmDao;

    private LocalDataSource(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    public static LocalDataSource getInstance(FilmDao filmDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalDataSource(filmDao);
        }
        return INSTANCE;
    }

    public DataSource.Factory<Integer, FilmEntity> getMovies() {
        return filmDao.getMovie();
    }

    public DataSource.Factory<Integer, FilmEntity> getShows() {
        return filmDao.getShow();
    }

    public DataSource.Factory<Integer, FilmEntity> getMovieFavorites() {
        return filmDao.getMovieFavorite();
    }

    public DataSource.Factory<Integer, FilmEntity> getShowFavorites() {
        return filmDao.getShowFavorite();
    }

    public LiveData<FilmEntity> getDetail(String id) {
        return filmDao.getDetailFilm(id);
    }

    public void insertFilm(List<FilmEntity> films) {
        filmDao.insertFilm(films);
    }

    public void setFilmFavorites(FilmEntity film, boolean newState) {
        film.setFavorited(newState);
        filmDao.updateFilm(film);
    }
}
