package com.muhammetkudur.home

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.muhammetkudur.domain.mapper.Mapper
import com.muhammetkudur.domain.model.TopRatedMovieEntity
import com.muhammetkudur.domain.usecase.topratedusecase.GetTopRatedMoviesUseCase
import com.muhammetkudur.ui.base.BaseViewModel
import com.muhammetkudur.ui.model.TopRatedMovieUiData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val topRatedUiDataMapper: Mapper<TopRatedMovieEntity, TopRatedMovieUiData>
) : BaseViewModel() {

    fun getTopRatedMoviesData(): Flow<PagingData<TopRatedMovieUiData>> {
        return flow {
            getTopRatedMoviesUseCase.invoke()
                .onStart { showIndicator() }
                .map { pagingTopRatedData ->
                    hideIndicator()
                    pagingTopRatedData.map { topRatedEntity ->
                        topRatedUiDataMapper.map(topRatedEntity)
                    }
                }.cachedIn(viewModelScope)
        }
    }
}