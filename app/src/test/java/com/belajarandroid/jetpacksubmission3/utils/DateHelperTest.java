package com.belajarandroid.jetpacksubmission3.utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateHelperTest {

    private DateHelper dateHelper;

    @Before
    public void before() {
        dateHelper = new DateHelper();
    }

    @Test
    public void dateFormat() {
        String date = dateHelper.dateFormat("2020-02-09");
        assertEquals("Feb 09, 2020", date);
    }
}