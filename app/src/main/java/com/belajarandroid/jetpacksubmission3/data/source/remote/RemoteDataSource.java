package com.belajarandroid.jetpacksubmission3.data.source.remote;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.belajarandroid.jetpacksubmission3.data.source.remote.response.ApiResponse;
import com.belajarandroid.jetpacksubmission3.data.source.remote.response.MovieResponse;
import com.belajarandroid.jetpacksubmission3.data.source.remote.response.ShowResponse;
import com.belajarandroid.jetpacksubmission3.utils.EspressoIdlingResource;
import com.belajarandroid.jetpacksubmission3.utils.JsonHelper;

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

    public LiveData<ApiResponse<List<MovieResponse>>> getMovie() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<MovieResponse>>> resultMovie = new MutableLiveData<>();
        handler.postDelayed(() -> {
            resultMovie.setValue(ApiResponse.success(jsonHelper.loadMovie()));
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILIS);
        return resultMovie;
    }

    public LiveData<ApiResponse<List<ShowResponse>>> getShow() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<ShowResponse>>> resultShow = new MutableLiveData<>();
        handler.postDelayed(() -> {
            resultShow.setValue(ApiResponse.success(jsonHelper.loadShow()));
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILIS);
        return resultShow;
    }
}
