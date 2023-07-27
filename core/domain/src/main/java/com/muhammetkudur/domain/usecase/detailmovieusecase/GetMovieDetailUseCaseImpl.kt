package com.muhammetkudur.domain.usecase.detailmovieusecase

import com.muhammetkudur.common.networkresponse.NetworkResponse
import com.muhammetkudur.domain.model.MovieDetailEntity
import com.muhammetkudur.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class GetMovieDetailUseCaseImpl @Inject constructor(private val movieRepository: MovieRepository) :
    GetMovieDetailUseCase {
    override fun invoke(id:Int): Flow<NetworkResponse<MovieDetailEntity>> = movieRepository.fetchMovieById(id)
}