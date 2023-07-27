package com.muhammetkudur.data.api

import com.muhammetkudur.data.dto.Movie
import com.muhammetkudur.data.dto.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

interface MovieService {

    @GET(TOP_RATED)
    suspend fun fetchTopRatedMovies(
        @Query(LANGUAGE_QUERY) language: String = LANGUAGE,
        @Query(PAGE) page: Int
    ): MovieResponse

    @GET(DETAIL)
    suspend fun fetchMovieById(
        @Path(PATH_MOVIE_ID) id: Int,
        @Query(LANGUAGE_QUERY) language: String = LANGUAGE
    ): Response<Movie>

    companion object {
        private const val TOP_RATED = "movie/top_rated"
        private const val PATH_MOVIE_ID = "movie_id"
        private const val DETAIL = "movie/{$PATH_MOVIE_ID}"
        private const val PAGE = "page"
        private const val LANGUAGE_QUERY = "language"
        private const val LANGUAGE = "en-US"
    }
}