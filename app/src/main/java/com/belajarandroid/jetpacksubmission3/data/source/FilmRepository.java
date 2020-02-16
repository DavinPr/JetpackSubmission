package com.belajarandroid.jetpacksubmission3.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.belajarandroid.jetpacksubmission3.data.FilmEntity;
import com.belajarandroid.jetpacksubmission3.data.source.remote.RemoteDataSource;
import com.belajarandroid.jetpacksubmission3.data.source.remote.response.MovieResponse;
import com.belajarandroid.jetpacksubmission3.data.source.remote.response.ShowResponse;

import java.util.ArrayList;
import java.util.List;

public class FilmRepository implements FilmDataSource {

    private volatile static FilmRepository INSTANCE = null;

    private final RemoteDataSource remoteDataSource;

    private FilmRepository(@NonNull RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public static FilmRepository getInstance(RemoteDataSource remoteData) {
        if (INSTANCE == null) {
            synchronized (FilmRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FilmRepository(remoteData);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<List<FilmEntity>> getMovie() {
        MutableLiveData<List<FilmEntity>> filmResults = new MutableLiveData<>();
        remoteDataSource.getMovie(movieResponses -> {
            ArrayList<FilmEntity> movieList = new ArrayList<>();
            for (MovieResponse response : movieResponses) {
                FilmEntity movie = new FilmEntity(response.getMovieId(),
                        response.getMoviePoster(),
                        response.getMovieBackdrop(),
                        response.getMovieTitle(),
                        response.getMovieDate(),
                        response.getMovieRate(),
                        response.getMovieGenre(),
                        response.getMovieLang(),
                        response.getMovieOverview(),
                        response.getMoviePopularity());
                movieList.add(movie);
            }
            filmResults.postValue(movieList);
        });
        return filmResults;
    }

    @Override
    public LiveData<List<FilmEntity>> getShow() {
        MutableLiveData<List<FilmEntity>> filmResults = new MutableLiveData<>();
        remoteDataSource.getShow(showResponses -> {
            ArrayList<FilmEntity> showList = new ArrayList<>();
            for (ShowResponse response : showResponses) {
                FilmEntity show = new FilmEntity(response.getShowId(),
                        response.getShowPoster(),
                        response.getShowBackdrop(),
                        response.getShowTitle(),
                        response.getShowDate(),
                        response.getShowRate(),
                        response.getShowGenre(),
                        response.getShowLang(),
                        response.getShowOverview(),
                        response.getShowPopularity());
                showList.add(show);
            }
            filmResults.postValue(showList);
        });
        return filmResults;
    }

    @Override
    public LiveData<FilmEntity> getDetailMovie(String movieId) {
        MutableLiveData<FilmEntity> filmResult = new MutableLiveData<>();
        remoteDataSource.getMovie(movieResponses -> {
            FilmEntity filmEntity = null;
            for (MovieResponse response : movieResponses) {
                if (response.getMovieId().equals(movieId)) {
                    filmEntity = new FilmEntity(response.getMovieId(),
                            response.getMoviePoster(),
                            response.getMovieBackdrop(),
                            response.getMovieTitle(),
                            response.getMovieDate(),
                            response.getMovieRate(),
                            response.getMovieGenre(),
                            response.getMovieLang(),
                            response.getMovieOverview(),
                            response.getMoviePopularity());
                }
            }
            filmResult.postValue(filmEntity);
        });
        return filmResult;
    }

    @Override
    public LiveData<FilmEntity> getDetailShow(String showId) {
        MutableLiveData<FilmEntity> filmResults = new MutableLiveData<>();
        remoteDataSource.getShow(showResponses -> {
            FilmEntity filmEntity = null;
            for (ShowResponse response : showResponses) {
                if (response.getShowId().equals(showId)) {
                    filmEntity = new FilmEntity(response.getShowId(),
                            response.getShowPoster(),
                            response.getShowBackdrop(),
                            response.getShowTitle(),
                            response.getShowDate(),
                            response.getShowRate(),
                            response.getShowGenre(),
                            response.getShowLang(),
                            response.getShowOverview(),
                            response.getShowPopularity());
                }
            }
            filmResults.postValue(filmEntity);
        });
        return filmResults;
    }


}
