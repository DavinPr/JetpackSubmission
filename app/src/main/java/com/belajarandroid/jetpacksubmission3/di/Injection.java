package com.belajarandroid.jetpacksubmission3.di;

import android.content.Context;

import com.belajarandroid.jetpacksubmission3.data.FilmRepository;
import com.belajarandroid.jetpacksubmission3.data.source.local.LocalDataSource;
import com.belajarandroid.jetpacksubmission3.data.source.local.room.FilmDatabase;
import com.belajarandroid.jetpacksubmission3.data.source.remote.RemoteDataSource;
import com.belajarandroid.jetpacksubmission3.utils.AppExecutors;
import com.belajarandroid.jetpacksubmission3.utils.JsonHelper;

public class Injection {
    public static FilmRepository provideRepository(Context context) {

        FilmDatabase database = FilmDatabase.getInstance(context);

        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance(new JsonHelper(context));
        LocalDataSource localDataSource = LocalDataSource.getInstance(database.filmDao());
        AppExecutors appExecutors = new AppExecutors();

        return FilmRepository.getInstance(remoteDataSource, localDataSource, appExecutors);
    }
}
