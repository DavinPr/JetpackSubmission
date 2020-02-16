package com.belajarandroid.jetpacksubmission2.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.belajarandroid.jetpacksubmission2.data.FilmEntity;
import com.belajarandroid.jetpacksubmission2.data.source.FilmRepository;

import java.util.List;

public class MovieViewModel extends ViewModel {

    private FilmRepository filmRepository;

    public MovieViewModel(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    LiveData<List<FilmEntity>> getMovie() {
        return filmRepository.getMovie();
    }
}
