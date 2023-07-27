package com.muhammetkudur.domain.usecase.topratedusecase

import androidx.paging.PagingData
import com.muhammetkudur.domain.model.TopRatedMovieEntity
import com.muhammetkudur.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class GetTopRatedMoviesUseCaseImpl @Inject constructor(private val movieRepository: MovieRepository) :
    GetTopRatedMoviesUseCase {
    override fun invoke(): Flow<PagingData<TopRatedMovieEntity>> =
        movieRepository.fetchTopRatedMovies()
}