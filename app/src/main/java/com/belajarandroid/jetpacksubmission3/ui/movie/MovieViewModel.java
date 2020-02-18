package com.belajarandroid.jetpacksubmission3.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.belajarandroid.jetpacksubmission3.data.source.local.entity.FilmEntity;
import com.belajarandroid.jetpacksubmission3.data.FilmRepository;
import com.belajarandroid.jetpacksubmission3.vo.Resource;

import java.util.List;

public class MovieViewModel extends ViewModel {

    private FilmRepository filmRepository;

    public MovieViewModel(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    LiveData<Resource<List<FilmEntity>>> getMovie() {
        return filmRepository.getMovie();
    }
}
