package com.belajarandroid.jetpacksubmission3.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.belajarandroid.jetpacksubmission3.data.FilmEntity;
import com.belajarandroid.jetpacksubmission3.data.source.FilmRepository;

public class DetailViewModel extends ViewModel {
    private FilmRepository filmRepository;

    public DetailViewModel(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    LiveData<FilmEntity> getDetail(String id, String type) {
        LiveData<FilmEntity> filmEntity;
        if (type.equals("movie")) {
            filmEntity = filmRepository.getDetailMovie(id);
        } else {
            filmEntity = filmRepository.getDetailShow(id);
        }
        return filmEntity;
    }

}
