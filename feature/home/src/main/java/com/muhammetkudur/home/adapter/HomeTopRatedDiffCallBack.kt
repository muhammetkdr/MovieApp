package com.example.moviepagingxml.ui.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.muhammetkudur.ui.model.TopRatedMovieUiData

class HomeTopRatedDiffCallBack: DiffUtil.ItemCallback<TopRatedMovieUiData>(){
    override fun areItemsTheSame(oldItem: TopRatedMovieUiData, newItem: TopRatedMovieUiData): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: TopRatedMovieUiData, newItem: TopRatedMovieUiData): Boolean {
        return oldItem.title == newItem.title
    }
}