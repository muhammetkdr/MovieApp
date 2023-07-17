package com.muhammetkudur.data.source.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.muhammetkudur.data.api.MovieService
import com.muhammetkudur.data.dto.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class MovieRemoteDataSourceImpl @Inject constructor(
    private val movieService: MovieService,
) : MovieRemoteDataSource {

    override fun fetchTopRatedMovies(): Flow<PagingData<Movie>> =
        Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE, // ilk yüklemede kaç tane item yüklencek
                enablePlaceholders = false,
                initialLoadSize = 1, // scrolldan sonra her seferinde 10 item yükler
            ),
            pagingSourceFactory = {
                TopRatedMoviesPagingSource(movieService)
            }
        ).flow

    companion object {
        private const val PAGE_SIZE = 1
    }
}