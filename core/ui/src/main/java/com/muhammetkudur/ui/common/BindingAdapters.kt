package com.muhammetkudur.ui.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.muhammetkudur.ui.utils.Constants.MOVIE_IMAGE_BASE_URL

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

@BindingAdapter("setMovieImage")
fun ImageView.setMovieImage(moviePath:String?) {
    Glide.with(this).load(MOVIE_IMAGE_BASE_URL + moviePath)
        .into(this)
}