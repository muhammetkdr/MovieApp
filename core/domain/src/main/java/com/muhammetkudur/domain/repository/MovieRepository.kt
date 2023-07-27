package com.muhammetkudur.domain.repository

import androidx.paging.PagingData
import com.muhammetkudur.common.networkresponse.NetworkResponse
import com.muhammetkudur.domain.model.MovieDetailEntity
import com.muhammetkudur.domain.model.TopRatedMovieEntity
import kotlinx.coroutines.flow.Flow

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

interface MovieRepository {
    fun fetchTopRatedMovies(): Flow<PagingData<TopRatedMovieEntity>>
    fun fetchMovieById(id: Int): Flow<NetworkResponse<MovieDetailEntity>>
}