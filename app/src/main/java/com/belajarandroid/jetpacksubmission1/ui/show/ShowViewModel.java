package com.belajarandroid.jetpacksubmission1.ui.show;

import androidx.lifecycle.ViewModel;

import com.belajarandroid.jetpacksubmission1.data.FilmEntity;
import com.belajarandroid.jetpacksubmission1.utils.DataDummy;

import java.util.List;

public class ShowViewModel extends ViewModel {
    List<FilmEntity> getShow() {
        return DataDummy.generateDummyShow();
    }
}
