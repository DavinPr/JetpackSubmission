package com.belajarandroid.jetpacksubmission3.ui.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.belajarandroid.jetpacksubmission3.data.FilmRepository;
import com.belajarandroid.jetpacksubmission3.data.source.local.entity.FilmEntity;
import com.belajarandroid.jetpacksubmission3.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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
    private Observer<Resource<PagedList<FilmEntity>>> observer;

    @Mock
    private PagedList<FilmEntity> pagedList;

    @Before
    public void setUp() {
        viewModel = new MovieViewModel(filmRepository);
    }

    @Test
    public void getData() {
        Resource<PagedList<FilmEntity>> dummyFilm = Resource.success(pagedList);
        when(dummyFilm.data.size()).thenReturn(10);
        MutableLiveData<Resource<PagedList<FilmEntity>>> films = new MutableLiveData<>();
        films.setValue(dummyFilm);

        when(filmRepository.getMovie()).thenReturn(films);
        List<FilmEntity> filmEntities = viewModel.getMovie().getValue().data;
        verify(filmRepository).getMovie();
        assertNotNull(filmEntities);
        assertEquals(10, filmEntities.size());

        viewModel.getMovie().observeForever(observer);
        verify(observer).onChanged(dummyFilm);
    }
}