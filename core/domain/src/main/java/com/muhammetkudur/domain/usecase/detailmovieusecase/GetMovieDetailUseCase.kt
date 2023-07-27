package com.muhammetkudur.domain.usecase.detailmovieusecase

import com.muhammetkudur.common.networkresponse.NetworkResponse
import com.muhammetkudur.domain.model.MovieDetailEntity
import kotlinx.coroutines.flow.Flow

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

interface GetMovieDetailUseCase {
    operator fun invoke(id:Int): Flow<NetworkResponse<MovieDetailEntity>>
}