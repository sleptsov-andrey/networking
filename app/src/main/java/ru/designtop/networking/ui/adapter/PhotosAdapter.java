package ru.designtop.networking.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.bumptech.glide.RequestManager;

import java.util.ArrayList;
import java.util.List;

import ru.designtop.networking.data.network.dto.HitsDTO;

public final class PhotosAdapter extends RecyclerView.Adapter<PhotoViewHolder> {

    private RequestManager glideRequestManager;
    private final List<HitsDTO> items = new ArrayList<>();

    public PhotosAdapter(RequestManager glideRequestManager) {
        this.glideRequestManager = glideRequestManager;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return PhotoViewHolder.create(viewGroup, glideRequestManager);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder photoViewHolder, int position) {
        final HitsDTO pic = items.get(position);
        photoViewHolder.bindItem(pic);
    }

    public void replaceItems(@NonNull List<HitsDTO> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
