package com.belajarandroid.jetpacksubmission3.ui.detail;

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DetailViewModelTest {

    private DetailViewModel detailViewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private FilmRepository filmRepository;

    @Mock
    private Observer<FilmEntity> observer;

    @Before
    public void setUp() {
        detailViewModel = new DetailViewModel(filmRepository);
    }

    @Test
    public void getDetail() {
        FilmEntity dummyFilm = DataDummy.generateDummyMovie().get(0);
        String id = dummyFilm.getFilmId();
        String type = "movie";
        MutableLiveData<FilmEntity> filmEntity = new MutableLiveData<>();
        filmEntity.setValue(dummyFilm);
        when(filmRepository.getDetailMovie(dummyFilm.getFilmId())).thenReturn(filmEntity);
        FilmEntity entity = detailViewModel.getDetail(id, type).getValue();
        verify(filmRepository).getDetailMovie(id);
        assertNotNull(entity);
        assertEquals(dummyFilm.getFilmTitle(), entity.getFilmTitle());
        assertEquals(dummyFilm.getFilmRate(), entity.getFilmRate());

        detailViewModel.getDetail(id, type).observeForever(observer);
        verify(observer).onChanged(dummyFilm);
    }
}