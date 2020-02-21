package com.belajarandroid.jetpacksubmission3.ui.favorite;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.belajarandroid.jetpacksubmission3.data.FilmRepository;
import com.belajarandroid.jetpacksubmission3.data.source.local.entity.FilmEntity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FavoriteViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private FavoriteViewModel viewModel;
    private FilmRepository filmRepository = mock(FilmRepository.class);

    @Before
    public void setUp() {
        viewModel = new FavoriteViewModel(filmRepository);
    }

    @Test
    public void getMovieFavorites() {
        MutableLiveData<PagedList<FilmEntity>> film = new MutableLiveData<>();
        PagedList<FilmEntity> dummyMovie = mock(PagedList.class);
        when(dummyMovie.size()).thenReturn(20);

        film.setValue(dummyMovie);
        when(filmRepository.getFavoritedMovie()).thenReturn(film);

        List<FilmEntity> filmEntities = viewModel.getMovieFavorites().getValue();
        verify(filmRepository).getFavoritedMovie();
        assertNotNull(filmEntities);
        assertEquals(20, filmEntities.size());

        Observer<PagedList<FilmEntity>> observer = mock(Observer.class);
        viewModel.getMovieFavorites().observeForever(observer);
        verify(observer).onChanged(dummyMovie);
    }

    @Test
    public void getShowFavorites() {
        PagedList<FilmEntity> dummyShow = mock(PagedList.class);
        when(dummyShow.size()).thenReturn(20);
        MutableLiveData<PagedList<FilmEntity>> film = new MutableLiveData<>();
        film.setValue(dummyShow);

        when(filmRepository.getFavoritedShow()).thenReturn(film);
        List<FilmEntity> filmEntities = viewModel.getShowFavorites().getValue();
        assertNotNull(filmEntities);
        assertEquals(20, filmEntities.size());

        Observer<PagedList<FilmEntity>> observer = mock(Observer.class);
        viewModel.getShowFavorites().observeForever(observer);
        verify(observer).onChanged(dummyShow);
    }
}