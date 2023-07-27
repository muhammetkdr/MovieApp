package com.muhammetkudur.data.source.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.muhammetkudur.common.coroutine.Dispatcher
import com.muhammetkudur.common.coroutine.DispatcherType
import com.muhammetkudur.common.networkresponse.NetworkResponse
import com.muhammetkudur.data.api.MovieService
import com.muhammetkudur.data.dto.Movie
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class MovieRemoteDataSourceImpl @Inject constructor(
    private val movieService: MovieService,
    @Dispatcher(DispatcherType.Io) private val ioDispatcher : CoroutineDispatcher
) : MovieRemoteDataSource {

    override fun fetchTopRatedMovies(): Flow<PagingData<Movie>> =
        Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE, // ilk yüklemede kaç tane item yüklencek
                enablePlaceholders = false,
                initialLoadSize = 2, // scrolldan sonra her seferinde 2 item yükler
            ),
            pagingSourceFactory = {
                TopRatedMoviesPagingSource(movieService)
            }
        ).flow

    override fun fetchMovieById(id: Int): Flow<NetworkResponse<Movie>> = flow {
        try {
            emit(NetworkResponse.Loading)
            val response = movieService.fetchMovieById(id = id)
            if(response.isSuccessful){
                response.body()?.let {
                    emit(NetworkResponse.Success(it))
                } ?: emit(NetworkResponse.Error(NO_DATA))
            }else{
                emit(NetworkResponse.Error(NO_DATA))
            }
        }catch (e: Exception){
            emit(NetworkResponse.Error(e.message ?: NO_DATA))
        }
    }.flowOn(ioDispatcher)

    companion object {
        private const val PAGE_SIZE = 2
        private const val NO_DATA = "NO DATA!"
    }
}