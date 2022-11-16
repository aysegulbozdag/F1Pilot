package com.example.android.f1pilot.util.custombindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImage")
fun setImageF1Pilot(iv: ImageView, url:String?) {
    Glide.with(iv.context)
        .load(url)
        .centerCrop()
        .into(iv)
}