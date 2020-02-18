package com.belajarandroid.jetpacksubmission3.ui.show;

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
public class ShowViewModelTest {
    private ShowViewModel showViewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private FilmRepository filmRepository;

    @Mock
    private Observer<List<FilmEntity>> observer;

    @Before
    public void setUp() {
        showViewModel = new ShowViewModel(filmRepository);
    }

    @Test
    public void getShow() {
        ArrayList<FilmEntity> dummyFilm = DataDummy.generateDummyShow();
        MutableLiveData<List<FilmEntity>> films = new MutableLiveData<>();
        films.setValue(dummyFilm);

        when(filmRepository.getShow()).thenReturn(films);
        List<FilmEntity> filmEntities = showViewModel.getShow().getValue();
        verify(filmRepository).getShow();
        assertNotNull(filmEntities);
        assertEquals(10, filmEntities.size());

        showViewModel.getShow().observeForever(observer);
        verify(observer).onChanged(dummyFilm);
    }
}