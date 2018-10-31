package ru.designtop.networking.data.network.endpoints;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.designtop.networking.data.network.DefaultResponse;
import ru.designtop.networking.data.network.dto.HitsDTO;

public interface PicEndpoint {
    @GET("/api/")
    Single<Response<DefaultResponse<List<HitsDTO>>>> search(@Query("q") @NonNull String search);
}
