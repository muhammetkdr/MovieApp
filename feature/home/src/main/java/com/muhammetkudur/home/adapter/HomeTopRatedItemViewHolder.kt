package com.muhammetkudur.home.adapter

import com.muhammetkudur.home.databinding.AdapterTopratedItemBinding
import com.muhammetkudur.ui.base.BaseViewHolder
import com.muhammetkudur.ui.model.TopRatedMovieUiData

class HomeTopRatedItemViewHolder(
    private val binding: AdapterTopratedItemBinding
) : BaseViewHolder<TopRatedMovieUiData>(binding.root) {
    override fun bind(item: TopRatedMovieUiData, position: Int) {
       binding.data = item
    }
}