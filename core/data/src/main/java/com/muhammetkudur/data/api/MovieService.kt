package com.muhammetkudur.data.api

import com.muhammetkudur.data.dto.TopRatedMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

interface MovieService {

    @GET(TOP_RATED)
    suspend fun fetchTopRatedMovies(
        @Query(LANGUAGE) language: String,
        @Query(PAGE) page: Int
    ): TopRatedMovieResponse

    companion object {
        private const val TOP_RATED = "movie/top_rated"
        private const val PAGE = "page"
        private const val LANGUAGE = "language"
    }
}