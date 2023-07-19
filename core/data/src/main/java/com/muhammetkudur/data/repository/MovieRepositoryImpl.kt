package com.muhammetkudur.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.muhammetkudur.data.dto.TopRatedMovie
import com.muhammetkudur.data.source.remote.MovieRemoteDataSource
import com.muhammetkudur.domain.mapper.Mapper
import com.muhammetkudur.domain.model.TopRatedMovieEntity
import com.muhammetkudur.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val topRatedMovieMappar: Mapper<TopRatedMovie,TopRatedMovieEntity>
) : MovieRepository {
    override fun fetchTopRatedMovies(): Flow<PagingData<TopRatedMovieEntity>> {
        return movieRemoteDataSource.fetchTopRatedMovies().map { pagingData ->
            pagingData.map {movie ->
                mapTopRatedMovie(movie)
            }
        }
    }

    private fun mapTopRatedMovie(movie: TopRatedMovie) : TopRatedMovieEntity{
        return topRatedMovieMappar.map(movie)
    }
}