package com.muhammetkudur.data.source.remote

import androidx.paging.PagingData
import com.muhammetkudur.data.dto.Movie
import kotlinx.coroutines.flow.Flow

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

interface MovieRemoteDataSource {
    fun fetchTopRatedMovies(): Flow<PagingData<Movie>>
}