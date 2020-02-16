package com.belajarandroid.jetpacksubmission3.utils;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class GenreHelper {

    private Context context;

    public GenreHelper(Context context) {
        this.context = context;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private String parsingFileToString(String fileName) {
        try {
            InputStream is = context.getAssets().open(fileName);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new String(buffer);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String getMovieGenre(String genre) {
        String genreName = null;
        try {
            String json = parsingFileToString("movie_genre.json");
            if (json != null) {
                JSONObject responseObject = new JSONObject(json);
                JSONArray listArray = responseObject.getJSONArray("genres");
                for (int i = 0; i < listArray.length(); i++) {
                    if (genre.equals(listArray.getJSONObject(i).getString("id"))) {
                        genreName = listArray.getJSONObject(i).getString("name");
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return genreName;
    }

    public String getShowGenre(String genre) {
        String genreName = null;
        try {
            String json = parsingFileToString("tv_genre.json");
            if (json != null) {
                JSONObject responseObject = new JSONObject(json);
                JSONArray listArray = responseObject.getJSONArray("genres");
                for (int i = 0; i < listArray.length(); i++) {
                    if (genre.equals(listArray.getJSONObject(i).getString("id"))) {
                        genreName = listArray.getJSONObject(i).getString("name");
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return genreName;
    }
}
