package com.belajarandroid.jetpacksubmission3.ui.show;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.belajarandroid.jetpacksubmission3.data.FilmEntity;
import com.belajarandroid.jetpacksubmission3.data.source.FilmRepository;

import java.util.List;

public class ShowViewModel extends ViewModel {

    private FilmRepository filmRepository;

    public ShowViewModel(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public LiveData<List<FilmEntity>> getShow() {
        return filmRepository.getShow();
    }
}
