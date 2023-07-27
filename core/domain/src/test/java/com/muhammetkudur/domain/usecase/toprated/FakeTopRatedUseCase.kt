package com.muhammetkudur.domain.usecase.toprated

import androidx.paging.PagingData
import com.muhammetkudur.domain.model.TopRatedMovieEntity
import com.muhammetkudur.domain.testTopRatedMovieEntityList
import com.muhammetkudur.domain.usecase.topratedusecase.GetTopRatedMoviesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class FakeTopRatedUseCase : GetTopRatedMoviesUseCase {

    private var showError = false

    fun updateShowError(showError: Boolean) {
        this.showError = showError
    }

    override fun invoke(): Flow<PagingData<TopRatedMovieEntity>> = flow {
        if(showError){
            emit(PagingData.from(emptyList()))
        }else{
            emit(PagingData.from(testTopRatedMovieEntityList))
        }
    }
}