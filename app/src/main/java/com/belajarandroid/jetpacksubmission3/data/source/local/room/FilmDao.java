package com.belajarandroid.jetpacksubmission3.data.source.local.room;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.belajarandroid.jetpacksubmission3.data.source.local.entity.FilmEntity;

import java.util.List;

@Dao
public interface FilmDao {

    @Query("SELECT * FROM filmentities where filmType='movie'")
    DataSource.Factory<Integer, FilmEntity> getMovie();

    @Query("SELECT * FROM filmentities where filmType = 'tv'")
    DataSource.Factory<Integer, FilmEntity> getShow();

    @Query("SELECT * FROM filmentities where favorited = 1 and filmType = 'movie'")
    DataSource.Factory<Integer, FilmEntity> getMovieFavorite();

    @Query("SELECT * FROM filmentities where favorited = 1 and filmType = 'tv'")
    DataSource.Factory<Integer, FilmEntity> getShowFavorite();

    @Query("SELECT * FROM filmentities where filmId = :id")
    LiveData<FilmEntity> getDetailFilm(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFilm(List<FilmEntity> film);

    @Update
    void updateFilm(FilmEntity film);
}
