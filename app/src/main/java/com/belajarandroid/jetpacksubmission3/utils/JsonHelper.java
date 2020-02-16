package com.belajarandroid.jetpacksubmission3.utils;

import android.content.Context;

import com.belajarandroid.jetpacksubmission3.data.source.remote.response.MovieResponse;
import com.belajarandroid.jetpacksubmission3.data.source.remote.response.ShowResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonHelper {

    private Context context;

    public JsonHelper(Context context) {
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

    public List<MovieResponse> loadMovie() {
        ArrayList<MovieResponse> list = new ArrayList<>();
        try {
            String json = parsingFileToString("movie.json");
            if (json != null) {
                JSONObject responseObject = new JSONObject(json);
                JSONArray listArray = responseObject.getJSONArray("results");

                for (int i = 0; i < listArray.length(); i++) {
                    JSONObject movie = listArray.getJSONObject(i);

                    DateHelper dateHelper = new DateHelper();
                    GenreHelper genreHelper = new GenreHelper(context);

                    String id = movie.getString("id");
                    String title = movie.getString("title");
                    String poster = movie.getString("poster_path");
                    String backdrop = movie.getString("backdrop_path");
                    String date = dateHelper.dateFormat(movie.getString("release_date"));
                    String rate = String.valueOf(movie.getDouble("vote_average"));
                    String popularity = String.valueOf(movie.getDouble("popularity"));
                    String overview = movie.getString("overview");
                    String lang = movie.getString("original_language");

                    //get Genre Name
                    JSONArray genreArray = movie.getJSONArray("genre_ids");
                    String[] listGenre = new String[genreArray.length()];
                    for (int j = 0; j < genreArray.length(); j++) {
                        String genreId = genreArray.get(j).toString();
                        listGenre[j] = genreHelper.getMovieGenre(genreId);
                    }
                    String genre = Arrays.toString(listGenre).replace("[", "").replace("]", "");

                    MovieResponse movieResponse = new MovieResponse(id, poster, backdrop, title, date, rate, genre, lang, overview, popularity);
                    list.add(movieResponse);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ShowResponse> loadShow() {
        ArrayList<ShowResponse> list = new ArrayList<>();
        try {
            String json = parsingFileToString("tv.json");
            if (json != null) {
                JSONObject responseObject = new JSONObject(json);
                JSONArray listArray = responseObject.getJSONArray("results");

                for (int i = 0; i < listArray.length(); i++) {
                    JSONObject show = listArray.getJSONObject(i);

                    DateHelper dateHelper = new DateHelper();
                    GenreHelper genreHelper = new GenreHelper(context);

                    String id = show.getString("id");
                    String title = show.getString("name");
                    String poster = show.getString("poster_path");
                    String backdrop = show.getString("backdrop_path");
                    String date = dateHelper.dateFormat(show.getString("first_air_date"));
                    String rate = String.valueOf(show.getDouble("vote_average"));
                    String popularity = String.valueOf(show.getDouble("popularity"));
                    String overview = show.getString("overview");
                    String lang = show.getString("original_language");

                    //get Genre Name
                    JSONArray genreArray = show.getJSONArray("genre_ids");
                    String[] listGenre = new String[genreArray.length()];
                    for (int j = 0; j < genreArray.length(); j++) {
                        String genreId = genreArray.get(j).toString();
                        String genreName = genreHelper.getShowGenre(genreId);
                        listGenre[j] = genreName;
                    }
                    String genre = Arrays.toString(listGenre).replace("[", "").replace("]", "");

                    ShowResponse showResponse = new ShowResponse(id, poster, backdrop, title, date, rate, genre, lang, overview, popularity);
                    list.add(showResponse);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
