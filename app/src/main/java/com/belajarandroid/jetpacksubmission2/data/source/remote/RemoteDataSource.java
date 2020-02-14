package com.belajarandroid.jetpacksubmission2.data.source.remote;

import android.os.Handler;

import com.belajarandroid.jetpacksubmission2.data.source.remote.response.MovieResponse;
import com.belajarandroid.jetpacksubmission2.data.source.remote.response.ShowResponse;
import com.belajarandroid.jetpacksubmission2.utils.EspressoIdlingResource;
import com.belajarandroid.jetpacksubmission2.utils.JsonHelper;

import java.util.List;

public class RemoteDataSource {
    private static RemoteDataSource INSTANCE;
    private JsonHelper jsonHelper;
    private Handler handler = new Handler();
    private final long SERVICE_LATENCY_IN_MILIS = 2000;

    private RemoteDataSource(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteDataSource getInstance(JsonHelper helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource(helper);
        }
        return INSTANCE;
    }

    public void getMovie(LoadMovieCallback callback) {
        EspressoIdlingResource.increment();
        handler.postDelayed(() -> {
            callback.onMovieReceived(jsonHelper.loadMovie());
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILIS);
    }

    public void getShow(LoadShowCallback callback) {
        EspressoIdlingResource.increment();
        handler.postDelayed(() -> {
            callback.onShowCallback(jsonHelper.loadShow());
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILIS);
    }

    public interface LoadMovieCallback {
        void onMovieReceived(List<MovieResponse> movieResponses);
    }

    public interface LoadShowCallback {
        void onShowCallback(List<ShowResponse> showResponses);
    }
}
