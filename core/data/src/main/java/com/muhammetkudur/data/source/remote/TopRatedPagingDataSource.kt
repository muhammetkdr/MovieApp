package com.muhammetkudur.data.source.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.muhammetkudur.common.ONE_VALUE
import com.muhammetkudur.data.api.MovieService
import com.muhammetkudur.data.dto.TopRatedMovie
import kotlinx.coroutines.delay
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class TopRatedMoviesPagingSource @Inject constructor(
    private val movieApi: MovieService
): PagingSource<Int, TopRatedMovie>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TopRatedMovie> {
        return try {
            val pageNumber = params.key ?: STARTING_PAGE_INDEX
            if (pageNumber != STARTING_PAGE_INDEX) delay(LOAD_DELAY_MILLIS)
            val response = movieApi.fetchTopRatedMovies(language = "en-US", page = pageNumber)

            val prevKey = if (pageNumber == 1) null else pageNumber - 1
            val nextKey = pageNumber + 1

            LoadResult.Page(
                data = response.results,
                prevKey = prevKey,
                nextKey = nextKey
            )
        }catch (e: IOException){
            return LoadResult.Error(e)
        }catch (e: HttpException){
            val message = e.response()?.errorBody()?.string()
            LoadResult.Error(Throwable(message ?: ERROR_MESSAGE))
        }
    }

    override fun getRefreshKey(state: PagingState<Int, TopRatedMovie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(Int.ONE_VALUE) ?: anchorPage?.nextKey?.minus(Int.ONE_VALUE)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
        private const val LOAD_DELAY_MILLIS = 500L
        private const val ERROR_MESSAGE = "Http Exception, we couldn't handle your request."
    }
}