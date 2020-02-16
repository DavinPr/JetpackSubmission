package com.belajarandroid.jetpacksubmission3.data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.belajarandroid.jetpacksubmission3.data.FilmEntity;
import com.belajarandroid.jetpacksubmission3.data.source.remote.RemoteDataSource;
import com.belajarandroid.jetpacksubmission3.data.source.remote.response.MovieResponse;
import com.belajarandroid.jetpacksubmission3.data.source.remote.response.ShowResponse;
import com.belajarandroid.jetpacksubmission3.utils.DataDummy;
import com.belajarandroid.jetpacksubmission3.utils.LiveDataTestUtil;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

public class FilmRepositoryTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private RemoteDataSource remote = Mockito.mock(RemoteDataSource.class);
    private FakeFilmRepository filmRepository = new FakeFilmRepository(remote);

    private ArrayList<MovieResponse> movieResponses = DataDummy.generateRemoteDummyMovie();
    private String movieId = movieResponses.get(0).getMovieId();
    private ArrayList<ShowResponse> showResponses = DataDummy.generateRemoteDummyShow();
    private String showId = showResponses.get(0).getShowId();

    @Test
    public void getMovie() {
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadMovieCallback) invocation.getArguments()[0])
                    .onMovieReceived(movieResponses);
            return null;
        }).when(remote).getMovie(any(RemoteDataSource.LoadMovieCallback.class));
        List<FilmEntity> filmEntities = LiveDataTestUtil.getValue(filmRepository.getMovie());
        verify(remote).getMovie(any(RemoteDataSource.LoadMovieCallback.class));
        assertNotNull(filmEntities);
        assertEquals(movieResponses.size(), filmEntities.size());
    }

    @Test
    public void getShow() {
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadShowCallback) invocation.getArguments()[0])
                    .onShowCallback(showResponses);
            return null;
        }).when(remote).getShow(any(RemoteDataSource.LoadShowCallback.class));
        List<FilmEntity> filmEntities = LiveDataTestUtil.getValue(filmRepository.getShow());
        verify(remote).getShow(any(RemoteDataSource.LoadShowCallback.class));
        assertNotNull(filmEntities);
        assertEquals(showResponses.size(), filmEntities.size());
    }

    @Test
    public void getDetailMovie() {
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadMovieCallback) invocation.getArguments()[0])
                    .onMovieReceived(movieResponses);
            return null;
        }).when(remote).getMovie(any(RemoteDataSource.LoadMovieCallback.class));

        FilmEntity entity = LiveDataTestUtil.getValue(filmRepository.getDetailMovie(movieId));
        verify(remote).getMovie(any(RemoteDataSource.LoadMovieCallback.class));
        MovieResponse response = movieResponses.get(0);
        assertNotNull(entity);
        assertEquals(response.getMovieTitle(), entity.getFilmTitle());
        assertEquals(response.getMovieDate(), entity.getFilmDate());
    }

    @Test
    public void getDetailShow() {
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadShowCallback) invocation.getArguments()[0])
                    .onShowCallback(showResponses);
            return null;
        }).when(remote).getShow(any(RemoteDataSource.LoadShowCallback.class));

        FilmEntity entity = LiveDataTestUtil.getValue(filmRepository.getDetailShow(showId));
        verify(remote).getShow(any(RemoteDataSource.LoadShowCallback.class));
        ShowResponse response = showResponses.get(0);
        assertNotNull(entity);
        assertEquals(response.getShowTitle(), entity.getFilmTitle());
        assertEquals(response.getShowDate(), entity.getFilmDate());
    }
}