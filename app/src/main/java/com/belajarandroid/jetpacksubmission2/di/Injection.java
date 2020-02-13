package com.belajarandroid.jetpacksubmission2.di;

import android.content.Context;

import com.belajarandroid.jetpacksubmission2.data.source.FilmRepository;
import com.belajarandroid.jetpacksubmission2.data.source.remote.RemoteDataSource;
import com.belajarandroid.jetpacksubmission2.utils.JsonHelper;

public class Injection {
    public static FilmRepository provideRepository(Context context){
        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance(new JsonHelper(context));

        return FilmRepository.getInstance(remoteDataSource);
    }
}
