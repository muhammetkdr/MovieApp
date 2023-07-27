package com.muhammetkudur.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.muhammetkudur.common.mapNetworkResult
import com.muhammetkudur.common.networkresponse.NetworkResponse
import com.muhammetkudur.data.dto.Movie
import com.muhammetkudur.data.source.remote.MovieRemoteDataSource
import com.muhammetkudur.domain.mapper.Mapper
import com.muhammetkudur.domain.model.MovieDetailEntity
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
    private val movieMapper: Mapper<Movie, TopRatedMovieEntity>,
    private val detailMovieMapper: Mapper<Movie, MovieDetailEntity>
) : MovieRepository {
    override fun fetchTopRatedMovies(): Flow<PagingData<TopRatedMovieEntity>> {
        return movieRemoteDataSource.fetchTopRatedMovies().map { pagingData ->
            pagingData.map { movie ->
                mapTopRatedMovie(movie)
            }
        }
    }

    override fun fetchMovieById(id: Int): Flow<NetworkResponse<MovieDetailEntity>> {
        return movieRemoteDataSource.fetchMovieById(id).map {
            it.mapNetworkResult { detailMovieMapper.map(this) }
        }
    }

    private fun mapTopRatedMovie(movie: Movie): TopRatedMovieEntity {
        return movieMapper.map(movie)
    }
}