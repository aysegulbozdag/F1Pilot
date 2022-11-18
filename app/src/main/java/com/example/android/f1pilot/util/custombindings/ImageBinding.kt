package com.example.android.f1pilot.util.custombindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.android.f1pilot.R

@BindingAdapter("loadImage")
fun setImageF1Pilot(iv: ImageView, url:String?) {
    Glide.with(iv.context)
        .load(url)
        .centerCrop()
        .into(iv)
}

@BindingAdapter("loadFav")
fun favBinding(iv:ImageView?, isFavCharacter : Boolean) {
    if (isFavCharacter)
        iv?.setImageResource(R.drawable.ic_baseline_favorite_24)
    else iv?.setImageResource(R.drawable.ic_baseline_favorite_border_24)
}