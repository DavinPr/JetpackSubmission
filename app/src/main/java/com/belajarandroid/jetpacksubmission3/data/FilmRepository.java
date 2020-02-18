package com.belajarandroid.jetpacksubmission3.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.belajarandroid.jetpacksubmission3.data.source.local.LocalDataSource;
import com.belajarandroid.jetpacksubmission3.data.source.local.entity.FilmEntity;
import com.belajarandroid.jetpacksubmission3.data.source.remote.RemoteDataSource;
import com.belajarandroid.jetpacksubmission3.data.source.remote.response.ApiResponse;
import com.belajarandroid.jetpacksubmission3.data.source.remote.response.MovieResponse;
import com.belajarandroid.jetpacksubmission3.data.source.remote.response.ShowResponse;
import com.belajarandroid.jetpacksubmission3.utils.AppExecutors;
import com.belajarandroid.jetpacksubmission3.vo.Resource;

import java.util.ArrayList;
import java.util.List;

public class FilmRepository implements FilmDataSource {

    private volatile static FilmRepository INSTANCE = null;

    private final RemoteDataSource remoteDataSource;
    private final LocalDataSource localDataSource;
    private final AppExecutors appExecutors;

    public FilmRepository(@NonNull RemoteDataSource remoteDataSource, @NonNull LocalDataSource localDataSource, AppExecutors appExecutors) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        this.appExecutors = appExecutors;
    }

    public static FilmRepository getInstance(RemoteDataSource remoteData, LocalDataSource localDataSource, AppExecutors appExecutors) {
        if (INSTANCE == null) {
            synchronized (FilmRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FilmRepository(remoteData, localDataSource, appExecutors);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<Resource<List<FilmEntity>>> getMovie() {
        return new NetworkBoundResource<List<FilmEntity>, List<MovieResponse>>(appExecutors) {

            @Override
            protected LiveData<List<FilmEntity>> loadFromDB() {
                return localDataSource.getMovies();
            }

            @Override
            protected Boolean shouldFetch(List<FilmEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                return remoteDataSource.getMovie();
            }

            @Override
            protected void saveCallResult(List<MovieResponse> movieResponses) {
                ArrayList<FilmEntity> movieList = new ArrayList<>();
                for (MovieResponse response : movieResponses) {
                    FilmEntity movie = new FilmEntity(response.getMovieId(),
                            "movie",
                            response.getMoviePoster(),
                            response.getMovieBackdrop(),
                            response.getMovieTitle(),
                            response.getMovieDate(),
                            response.getMovieRate(),
                            response.getMovieGenre(),
                            response.getMovieLang(),
                            response.getMovieOverview(),
                            response.getMoviePopularity(),
                            false);
                    movieList.add(movie);
                }
                localDataSource.insertFilm(movieList);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<FilmEntity>>> getShow() {
        return new NetworkBoundResource<List<FilmEntity>, List<ShowResponse>>(appExecutors) {

            @Override
            protected LiveData<List<FilmEntity>> loadFromDB() {
                return localDataSource.getShows();
            }

            @Override
            protected Boolean shouldFetch(List<FilmEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<ShowResponse>>> createCall() {
                return remoteDataSource.getShow();
            }

            @Override
            protected void saveCallResult(List<ShowResponse> showResponses) {
                ArrayList<FilmEntity> showList = new ArrayList<>();
                for (ShowResponse response : showResponses) {
                    FilmEntity show = new FilmEntity(response.getShowId(),
                            "tv",
                            response.getShowPoster(),
                            response.getShowBackdrop(),
                            response.getShowTitle(),
                            response.getShowDate(),
                            response.getShowRate(),
                            response.getShowGenre(),
                            response.getShowLang(),
                            response.getShowOverview(),
                            response.getShowPopularity(),
                            false);
                    showList.add(show);
                }
                localDataSource.insertFilm(showList);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<List<FilmEntity>> getFavoritedMovie() {
        return localDataSource.getMovieFavorites();
    }

    @Override
    public LiveData<List<FilmEntity>> getFavoritedShow() {
        return localDataSource.getShowFavorites();
    }

    @Override
    public LiveData<Resource<FilmEntity>> getDetailMovie(String movieId) {
        return new NetworkBoundResource<FilmEntity, MovieResponse>(appExecutors) {
            @Override
            protected LiveData<FilmEntity> loadFromDB() {
                return localDataSource.getDetail(movieId);
            }

            @Override
            protected Boolean shouldFetch(FilmEntity data) {
                return (data == null);
            }

            @Override
            protected LiveData<ApiResponse<MovieResponse>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(MovieResponse data) {

            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<FilmEntity>> getDetailShow(String showId) {
        return new NetworkBoundResource<FilmEntity, ShowResponse>(appExecutors) {

            @Override
            protected LiveData<FilmEntity> loadFromDB() {
                return localDataSource.getDetail(showId);
            }

            @Override
            protected Boolean shouldFetch(FilmEntity data) {
                return (data == null);
            }

            @Override
            protected LiveData<ApiResponse<ShowResponse>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(ShowResponse data) {

            }
        }.asLiveData();
    }

    @Override
    public void setFilmFavorite(FilmEntity entity, boolean state) {
        appExecutors.diskIO().execute(() -> localDataSource.setFilmFavorites(entity, state));
    }


}
