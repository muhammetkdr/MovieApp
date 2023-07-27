package com.muhammetkudur.data.repository

import androidx.paging.PagingData
import com.muhammetkudur.common.networkresponse.NetworkResponse
import com.muhammetkudur.data.testMovieDetailEntity
import com.muhammetkudur.data.testTopRatedMovieEntityList
import com.muhammetkudur.domain.model.MovieDetailEntity
import com.muhammetkudur.domain.model.TopRatedMovieEntity
import com.muhammetkudur.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class FakeMovieRepository : MovieRepository {
    private var showErrorForTopRatedMovies = false
    private var showErrorForMovieDetail = false

    fun updateShowErrorForTopRatedMovies(showError: Boolean) {
        this.showErrorForTopRatedMovies = showError
    }

    fun updateShowErrorForMovieDetail(showError: Boolean) {
        this.showErrorForMovieDetail = showError
    }

    override fun fetchTopRatedMovies(): Flow<PagingData<TopRatedMovieEntity>> = flow {
        if (showErrorForTopRatedMovies) {
            emit(PagingData.from(emptyList()))
        } else {
            emit(PagingData.from(testTopRatedMovieEntityList))
        }
    }

    override fun fetchMovieById(id: Int): Flow<NetworkResponse<MovieDetailEntity>> = flow {
        emit(NetworkResponse.Loading)
        if(showErrorForMovieDetail){
            emit(NetworkResponse.Error("Something bad happened..."))
        }else{
            emit(NetworkResponse.Success(testMovieDetailEntity))
        }
    }
}