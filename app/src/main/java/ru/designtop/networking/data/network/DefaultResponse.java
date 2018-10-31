package ru.designtop.networking.data.network;

import android.support.annotation.Nullable;

public class DefaultResponse<T> {

    private T hits;

    @Nullable
    public T getData() {
        return hits;
    }
}
