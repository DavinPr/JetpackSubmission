package com.belajarandroid.jetpacksubmission2.ui.show;

import com.belajarandroid.jetpacksubmission2.data.FilmEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ShowViewModelTest {
    private ShowViewModel showViewModel;

    @Before
    public void setUp() {
        showViewModel = new ShowViewModel();
    }

    @Test
    public void getShow() {
        List<FilmEntity> filmEntities = showViewModel.getShow();
        assertNotNull(filmEntities);
        assertEquals(10, filmEntities.size());
    }
}