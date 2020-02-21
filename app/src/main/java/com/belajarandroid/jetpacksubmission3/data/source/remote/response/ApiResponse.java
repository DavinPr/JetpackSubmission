package com.belajarandroid.jetpacksubmission3.data.source.remote.response;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.belajarandroid.jetpacksubmission3.data.source.remote.StatusResponse;

import static com.belajarandroid.jetpacksubmission3.data.source.remote.StatusResponse.ERROR;
import static com.belajarandroid.jetpacksubmission3.data.source.remote.StatusResponse.SUCCESS;

public class ApiResponse<T> {

    @NonNull
    public final StatusResponse status;

    @Nullable
    public final String message;

    @Nullable
    public final T body;

    private ApiResponse(@NonNull StatusResponse status, @Nullable String message, @Nullable T body) {
        this.status = status;
        this.message = message;
        this.body = body;
    }

    public static <T> ApiResponse<T> success(@Nullable T body) {
        return new ApiResponse<>(SUCCESS, null, body);
    }

    public static <T> ApiResponse<T> error(String msg, @Nullable T body) {
        return new ApiResponse<>(ERROR, msg, body);
    }
}
