package com.belajarandroid.jetpacksubmission3.utils;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class DateHelper {
    String dateFormat(String date) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat currDf = new SimpleDateFormat("yyyy-MM-dd");

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat newDf = new SimpleDateFormat("MMM dd, yyyy");
        try {
            Date currDate = currDf.parse(date);
            if (currDate != null) {
                return newDf.format(currDate);
            } else {
                return null;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
