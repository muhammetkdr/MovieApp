package com.muhammetkudur.domain.usecase

import androidx.paging.PagingData
import com.muhammetkudur.domain.model.TopRatedMovieEntity
import kotlinx.coroutines.flow.Flow

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

interface GetTopRatedMoviesUseCase {
    operator fun invoke(): Flow<PagingData<TopRatedMovieEntity>>
}