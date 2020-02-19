package com.belajarandroid.jetpacksubmission3.ui.favorite;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.belajarandroid.jetpacksubmission3.data.FilmRepository;
import com.belajarandroid.jetpacksubmission3.data.source.local.entity.FilmEntity;

public class FavoriteViewModel extends ViewModel {
    private FilmRepository filmRepository;

    public FavoriteViewModel(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public LiveData<PagedList<FilmEntity>> getMovieFavorites(){
        return filmRepository.getFavoritedMovie();
    }

    public LiveData<PagedList<FilmEntity>> getShowFavorites(){
        return filmRepository.getFavoritedShow();
    }
}
