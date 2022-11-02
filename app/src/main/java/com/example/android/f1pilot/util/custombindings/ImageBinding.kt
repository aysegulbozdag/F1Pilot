package com.example.android.f1pilot.util.custombindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImage")
fun setPosterMovie(iv: ImageView, url:String?) {
    Glide.with(iv.context)
        .load("http://image.tmdb.org/t/p/w500$url")
        .centerCrop()
        .into(iv)
}