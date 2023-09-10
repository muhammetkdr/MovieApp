package com.muhammetkudur.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.muhammetkudur.common.UiState
import com.muhammetkudur.detail.databinding.FragmentDetailBinding
import com.muhammetkudur.ui.base.BaseFragment
import com.muhammetkudur.ui.common.collectFlow
import com.muhammetkudur.ui.common.setMovieImage
import com.muhammetkudur.ui.common.showSnackbar
import com.muhammetkudur.ui.model.MovieDetailUiData
import com.muhammetkudur.ui.utils.extensions.inflate
import dagger.hilt.android.AndroidEntryPoint

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

@AndroidEntryPoint
class DetailFragment : BaseFragment(R.layout.fragment_detail) {

    private val binder by inflate(FragmentDetailBinding::bind)
    override val viewModel by viewModels<DetailViewModel>()
    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeDetailUiData()
        fetchDetailMovieData()
    }

    private fun fetchDetailMovieData() {
        viewModel.fetchMovieDetailData(args.id)
    }

    private fun observeDetailUiData() {
        collectFlow(viewModel.detailMovieData) {
            when (it) {
                is UiState.Success -> {
                    setUiState(it.data)
                }

                is UiState.Error -> {
                    requireView().showSnackbar(it.message)
                }

                UiState.Idle -> Unit
            }
        }
    }

    private fun setUiState(data: MovieDetailUiData) {
        with(binder) {
            ivPosterPath.setMovieImage(data.posterUrl)
            tvMovieTitle.text = data.title
            tvOverview.text = data.overview
        }
    }

}