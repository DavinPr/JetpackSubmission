package com.belajarandroid.jetpacksubmission3.ui.show;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.belajarandroid.jetpacksubmission3.data.source.local.entity.FilmEntity;
import com.belajarandroid.jetpacksubmission3.data.FilmRepository;
import com.belajarandroid.jetpacksubmission3.vo.Resource;

import java.util.List;

public class ShowViewModel extends ViewModel {

    private FilmRepository filmRepository;

    public ShowViewModel(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public LiveData<Resource<List<FilmEntity>>> getShow() {
        return filmRepository.getShow();
    }
}
