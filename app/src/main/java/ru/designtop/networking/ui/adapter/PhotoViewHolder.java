package ru.designtop.networking.ui.adapter;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import ru.designtop.networking.R;
import ru.designtop.networking.data.network.dto.HitsDTO;

public final class PhotoViewHolder extends RecyclerView.ViewHolder {

    private static final int LAYOUT = R.layout.item_gif;

    private RequestManager imageLoader;
    private ImageView ivPic;
    private ProgressBar progressBar;

    public static PhotoViewHolder create(@NonNull ViewGroup parent, RequestManager glideRequestManager) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(LAYOUT, parent, false);
        return new PhotoViewHolder(view, glideRequestManager);
    }

    private PhotoViewHolder(@NonNull View itemView, RequestManager glideRequestManager) {
        super(itemView);
        this.imageLoader = glideRequestManager;
        findViews(itemView);
    }


    public void bindItem(@NonNull HitsDTO pic) {

        progressBar.setVisibility(View.VISIBLE);

        imageLoader.load(pic.getUrl())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e,
                                                Object model,
                                                Target<Drawable> target,
                                                boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource,
                                                   Object model,
                                                   Target<Drawable> target,
                                                   DataSource dataSource,
                                                   boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .thumbnail(0.3f)
                .into(ivPic);

    }

    private void findViews(@NonNull View itemView) {
        ivPic = itemView.findViewById(R.id.iv_gif);
        progressBar = itemView.findViewById(R.id.progress_bar);
    }
}
