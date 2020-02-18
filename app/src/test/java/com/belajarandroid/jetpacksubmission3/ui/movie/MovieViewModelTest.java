package com.belajarandroid.jetpacksubmission3.ui.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.belajarandroid.jetpacksubmission3.data.source.local.entity.FilmEntity;
import com.belajarandroid.jetpacksubmission3.data.FilmRepository;
import com.belajarandroid.jetpacksubmission3.utils.DataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieViewModelTest {

    private MovieViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private FilmRepository filmRepository;

    @Mock
    private Observer<List<FilmEntity>> observer;

    @Before
    public void setUp() {
        viewModel = new MovieViewModel(filmRepository);
    }

    @Test
    public void getData() {
        ArrayList<FilmEntity> dummyFilm = DataDummy.generateDummyMovie();
        MutableLiveData<List<FilmEntity>> films = new MutableLiveData<>();
        films.setValue(dummyFilm);

        when(filmRepository.getMovie()).thenReturn(films);
        List<FilmEntity> filmEntities = viewModel.getMovie().getValue();
        verify(filmRepository).getMovie();
        assertNotNull(filmEntities);
        assertEquals(10, filmEntities.size());

        viewModel.getMovie().observeForever(observer);
        verify(observer).onChanged(dummyFilm);
    }
}