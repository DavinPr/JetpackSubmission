package com.belajarandroid.jetpacksubmission1.ui.movie;

import androidx.lifecycle.ViewModel;

import com.belajarandroid.jetpacksubmission1.data.FilmEntity;
import com.belajarandroid.jetpacksubmission1.utils.DataDummy;

import java.util.List;

public class MovieViewModel extends ViewModel {


    List<FilmEntity> getCourse() {
        return DataDummy.generateDummyMovie();
    }
}
