package com.belajarandroid.jetpacksubmission2.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.belajarandroid.jetpacksubmission2.data.source.FilmRepository;
import com.belajarandroid.jetpacksubmission2.di.Injection;
import com.belajarandroid.jetpacksubmission2.ui.detail.DetailViewModel;
import com.belajarandroid.jetpacksubmission2.ui.movie.MovieViewModel;
import com.belajarandroid.jetpacksubmission2.ui.show.ShowViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;

    private final FilmRepository filmRepository;

    private ViewModelFactory(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public static ViewModelFactory getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(context));
                }
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            return (T) new MovieViewModel(filmRepository);
        } else if (modelClass.isAssignableFrom(ShowViewModel.class)) {
            return (T) new ShowViewModel(filmRepository);
        } else if (modelClass.isAssignableFrom(DetailViewModel.class)) {
            return (T) new DetailViewModel(filmRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
