package com.zhihu.matisse.engine.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.zhihu.matisse.engine.ImageEngine;

import coil.Coil;
import coil.ImageLoader;
import coil.ImageLoaderFactory;
import coil.request.ImageRequest;
import coil.util.CoilUtils;

public class CoilEngine implements ImageEngine {
    @Override
    public void loadThumbnail(Context context, int resize, Drawable placeholder, ImageView imageView, Uri uri) {
        ImageLoader imageLoader = Coil.imageLoader(context);
        ImageRequest request = new ImageRequest.Builder(context)
                .data(uri)
                .size(resize)
                .placeholder(placeholder)
                .target(imageView)
                .build();
        imageLoader.enqueue(request);
    }

    @Override
    public void loadGifThumbnail(Context context, int resize, Drawable placeholder, ImageView imageView, Uri uri) {
        ImageLoader imageLoader = Coil.imageLoader(context);
        ImageRequest request = new ImageRequest.Builder(context)
                .data(uri)
                .size(resize)
                .placeholder(placeholder)
                .target(imageView)
                .build();
        imageLoader.enqueue(request);
    }

    @Override
    public void loadImage(Context context, int resizeX, int resizeY, ImageView imageView, Uri uri) {
        ImageLoader imageLoader = Coil.imageLoader(context);
        ImageRequest request = new ImageRequest.Builder(context)
                .data(uri)
                .size(resizeX, resizeY)
                .target(imageView)
                .build();
        imageLoader.enqueue(request);
    }

    @Override
    public void loadLargeImage(Context context, int resizeX, int resizeY, SubsamplingScaleImageView imageView, Uri uri) {

    }

    @Override
    public void loadGifImage(Context context, int resizeX, int resizeY, ImageView imageView, Uri uri) {
        loadImage(context, resizeX, resizeY, imageView, uri);
    }

    @Override
    public boolean supportAnimatedGif() {
        return false;
    }
}
