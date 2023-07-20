package com.muhammetkudur.ui.utils

import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.muhammetkudur.ui.databinding.AdapterNetworkstateItemBinding

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class PagingLoadStateAdapter<T : Any, VH : RecyclerView.ViewHolder>(
    private val pagingAdapter: PagingDataAdapter<T, VH>
) : LoadStateAdapter<PagingLoadStateAdapter.NetworkStateItemViewHolder>() {
    override fun onBindViewHolder(
        holder: NetworkStateItemViewHolder,
        loadState: LoadState
    ) = holder.bind(loadState)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): NetworkStateItemViewHolder =
        NetworkStateItemViewHolder(parent.inflateAdapterItem(AdapterNetworkstateItemBinding::inflate)) { pagingAdapter.retry() }

    class NetworkStateItemViewHolder(
        private val binding: AdapterNetworkstateItemBinding,
        private val retryCallback: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.buttonRetry.setOnClickListener { retryCallback() }
        }

        fun bind(loadState: LoadState) {
            with(binding) {
                if (loadState is LoadState.Error) {
                    errorMessage.text = loadState.error.localizedMessage
                }
                stateProgress.isVisible = loadState is LoadState.Loading
                buttonRetry.isVisible = loadState is LoadState.Error
                errorMessage.isVisible = (loadState as? LoadState.Error)?.error?.message.isNullOrBlank().not()
            }
        }
    }
}