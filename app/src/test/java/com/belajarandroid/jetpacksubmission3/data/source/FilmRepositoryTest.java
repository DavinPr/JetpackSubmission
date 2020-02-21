package com.belajarandroid.jetpacksubmission3.data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;

import com.belajarandroid.jetpacksubmission3.data.source.local.LocalDataSource;
import com.belajarandroid.jetpacksubmission3.data.source.local.entity.FilmEntity;
import com.belajarandroid.jetpacksubmission3.data.source.remote.RemoteDataSource;
import com.belajarandroid.jetpacksubmission3.data.source.remote.response.MovieResponse;
import com.belajarandroid.jetpacksubmission3.data.source.remote.response.ShowResponse;
import com.belajarandroid.jetpacksubmission3.utils.AppExecutors;
import com.belajarandroid.jetpacksubmission3.utils.DataDummy;
import com.belajarandroid.jetpacksubmission3.utils.LiveDataTestUtil;
import com.belajarandroid.jetpacksubmission3.utils.PagedListUtil;
import com.belajarandroid.jetpacksubmission3.vo.Resource;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FilmRepositoryTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private RemoteDataSource remote = Mockito.mock(RemoteDataSource.class);
    private LocalDataSource local = Mockito.mock(LocalDataSource.class);
    private AppExecutors appExecutors = Mockito.mock(AppExecutors.class);

    private FakeFilmRepository filmRepository = new FakeFilmRepository(remote, local, appExecutors);

    private ArrayList<MovieResponse> movieResponses = DataDummy.generateRemoteDummyMovie();
    private String movieId = movieResponses.get(0).getMovieId();
    private ArrayList<ShowResponse> showResponses = DataDummy.generateRemoteDummyShow();
    private String showId = showResponses.get(0).getShowId();

    @Test
    public void getMovie() {
        DataSource.Factory<Integer, FilmEntity> dataSourceFactory = mock(DataSource.Factory.class);
        when(local.getMovies()).thenReturn(dataSourceFactory);
        filmRepository.getMovie();

        Resource<PagedList<FilmEntity>> movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()));
        verify(local).getMovies();
        assertNotNull(movieEntities.data);
        assertEquals(movieResponses.size(), movieEntities.data.size());
    }

    @Test
    public void getShow() {
        DataSource.Factory<Integer, FilmEntity> dataSourceFactory = mock(DataSource.Factory.class);
        when(local.getShows()).thenReturn(dataSourceFactory);
        filmRepository.getShow();

        Resource<PagedList<FilmEntity>> filmEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyShow()));
        verify(local).getShows();
        assertNotNull(filmEntities.data);
        assertEquals(showResponses.size(), filmEntities.data.size());
    }

    @Test
    public void getDetailMovie() {
        MutableLiveData<FilmEntity> dummyEntity = new MutableLiveData<>();
        dummyEntity.setValue(DataDummy.generateDummyMovie().get(0));

        when(local.getDetail(movieId)).thenReturn(dummyEntity);
        Resource<FilmEntity> entity = LiveDataTestUtil.getValue(filmRepository.getDetailMovie(movieId));
        verify(local).getDetail(movieId);

        MovieResponse response = movieResponses.get(0);
        assertNotNull(entity.data);
        assertEquals(response.getMovieTitle(), entity.data.getFilmTitle());
        assertEquals(response.getMovieDate(), entity.data.getFilmDate());
    }

    @Test
    public void getDetailShow() {
        MutableLiveData<FilmEntity> dummyEntity = new MutableLiveData<>();
        dummyEntity.setValue(DataDummy.generateDummyShow().get(0));

        when(local.getDetail(showId)).thenReturn(dummyEntity);
        Resource<FilmEntity> entity = LiveDataTestUtil.getValue(filmRepository.getDetailShow(showId));
        verify(local).getDetail(showId);

        ShowResponse response = showResponses.get(0);
        assertNotNull(entity.data);
        assertEquals(response.getShowTitle(), entity.data.getFilmTitle());
        assertEquals(response.getShowDate(), entity.data.getFilmDate());
    }
}