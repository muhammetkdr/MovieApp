package com.muhammetkudur.domain.usecase.moviedetail

import com.muhammetkudur.common.networkresponse.NetworkResponse
import com.muhammetkudur.domain.model.MovieDetailEntity
import com.muhammetkudur.domain.testMovieDetailEntity
import com.muhammetkudur.domain.usecase.detailmovieusecase.GetMovieDetailUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class FakeMovieDetailUseCase : GetMovieDetailUseCase{

    private var showError = false

    fun updateShowError(showError: Boolean) {
        this.showError = showError
    }

    override fun invoke(id: Int): Flow<NetworkResponse<MovieDetailEntity>> = flow {
        emit(NetworkResponse.Loading)
        if(showError){
            emit(NetworkResponse.Error("Something bad happened.."))
        }else{
            emit(NetworkResponse.Success(testMovieDetailEntity))
        }
    }
}