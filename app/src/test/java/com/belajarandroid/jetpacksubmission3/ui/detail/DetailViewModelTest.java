package com.belajarandroid.jetpacksubmission3.ui.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.belajarandroid.jetpacksubmission3.data.FilmRepository;
import com.belajarandroid.jetpacksubmission3.data.source.local.entity.FilmEntity;
import com.belajarandroid.jetpacksubmission3.utils.DataDummy;
import com.belajarandroid.jetpacksubmission3.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DetailViewModelTest {

    private DetailViewModel detailViewModel;
    private Resource<FilmEntity> dummyFilm = Resource.success(DataDummy.generateDummyMovie().get(0));
    private String id = dummyFilm.data.getFilmId();

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private FilmRepository filmRepository;

    @Mock
    private Observer<Resource<FilmEntity>> observer;

    @Before
    public void setUp() {
        detailViewModel = new DetailViewModel(filmRepository);
        detailViewModel.setFilmId(id);
        detailViewModel.setType("movie");
    }

    @Test
    public void getDetail() {

        MutableLiveData<Resource<FilmEntity>> filmEntity = new MutableLiveData<>();
        filmEntity.setValue(dummyFilm);

        when(filmRepository.getDetailMovie(id)).thenReturn(filmEntity);

        detailViewModel.getDetail.observeForever(observer);
        verify(observer).onChanged(dummyFilm);
    }
}