package com.muhammetkudur.home.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.muhammetkudur.home.databinding.AdapterTopratedItemBinding
import com.muhammetkudur.ui.model.TopRatedMovieUiData
import com.muhammetkudur.ui.utils.extensions.inflateAdapterItem
import javax.inject.Inject

class HomeTopRatedRVAdapter @Inject constructor() :
    PagingDataAdapter<TopRatedMovieUiData, HomeTopRatedItemViewHolder>(HomeTopRatedDiffCallBack()) {

    private var onItemClickListener: ((TopRatedMovieUiData) -> Unit)? = null

    override fun onBindViewHolder(holder: HomeTopRatedItemViewHolder, position: Int) {
        getItem(position)?.let { characterUiData ->
            holder.onBind(characterUiData)
            holder.itemView.setOnClickListener {
                onItemClickListener?.invoke(characterUiData)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeTopRatedItemViewHolder {
        return HomeTopRatedItemViewHolder(parent.inflateAdapterItem(AdapterTopratedItemBinding::inflate))
    }

    fun setOnItemClickListener(listener: (TopRatedMovieUiData) -> Unit) {
        onItemClickListener = listener
    }

}