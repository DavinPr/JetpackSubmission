package com.belajarandroid.jetpacksubmission3.ui.show;

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
public class ShowViewModelTest {
    private ShowViewModel showViewModel;

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
        showViewModel = new ShowViewModel(filmRepository);
    }

    @Test
    public void getShow() {
        Resource<PagedList<FilmEntity>> dummyFilm = Resource.success(pagedList);
        when(dummyFilm.data.size()).thenReturn(10);
        MutableLiveData<Resource<PagedList<FilmEntity>>> films = new MutableLiveData<>();
        films.setValue(dummyFilm);

        when(filmRepository.getShow()).thenReturn(films);
        List<FilmEntity> filmEntities = showViewModel.getShow().getValue().data;
        verify(filmRepository).getShow();
        assertNotNull(filmEntities);
        assertEquals(10, filmEntities.size());

        showViewModel.getShow().observeForever(observer);
        verify(observer).onChanged(dummyFilm);
    }
}