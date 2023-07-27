package com.muhammetkudur.detail

import androidx.lifecycle.viewModelScope
import com.muhammetkudur.common.UiState
import com.muhammetkudur.common.networkresponse.NetworkResponse
import com.muhammetkudur.domain.mapper.Mapper
import com.muhammetkudur.domain.model.MovieDetailEntity
import com.muhammetkudur.domain.usecase.detailmovieusecase.GetMovieDetailUseCase
import com.muhammetkudur.ui.base.BaseViewModel
import com.muhammetkudur.ui.model.MovieDetailUiData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val movieDetailUseCase: GetMovieDetailUseCase,
    private val detailUiDataMapper: Mapper<MovieDetailEntity, MovieDetailUiData>
) : BaseViewModel() {

    private val _detailMovieData = MutableStateFlow<UiState<MovieDetailUiData>>(UiState.Idle)
    val detailMovieData: StateFlow<UiState<MovieDetailUiData>> = _detailMovieData

    fun fetchMovieDetailData(id: Int) {
        viewModelScope.launch {
            movieDetailUseCase.invoke(id = id)
                .onStart { showIndicator() }
                .onCompletion { hideIndicator() }
                .collect(::handleMovieDetailDataMapping)
        }
    }

    private fun handleMovieDetailDataMapping(movieDetailData: NetworkResponse<MovieDetailEntity>) {
        viewModelScope.launch(Dispatchers.IO) {
            when (movieDetailData) {
                is NetworkResponse.Error -> {
                    _detailMovieData.emit(UiState.Error(movieDetailData.error))
                }

                is NetworkResponse.Success -> {
                    _detailMovieData.emit(UiState.Success(
                            detailUiDataMapper.map(
                                movieDetailData.data
                            ))
                    )
                }

                NetworkResponse.Loading -> {
                    _detailMovieData.emit(UiState.Idle)
                }
            }
        }
    }
}