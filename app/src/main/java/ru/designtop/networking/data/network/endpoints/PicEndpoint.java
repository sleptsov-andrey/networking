package ru.designtop.networking.data.network.endpoints;

import android.support.annotation.NonNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.designtop.networking.data.network.DefaultResponse;
import ru.designtop.networking.data.network.dto.HitsDTO;

public interface PicEndpoint {
    @GET("/api/")
    Call<DefaultResponse<List<HitsDTO>>> search(@Query("q") @NonNull String search);

}
