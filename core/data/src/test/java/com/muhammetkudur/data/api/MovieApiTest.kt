package com.muhammetkudur.data.api

import com.google.common.truth.Truth.assertThat
import com.muhammetkudur.data.MOVIE_DETAIL_RESPONSE_FILE_NAME
import com.muhammetkudur.data.PAGE_NUM
import com.muhammetkudur.data.TOP_RATED_MOVIE_RESPONSE_FILE_NAME
import com.muhammetkudur.data.enqueueMockResponse
import com.muhammetkudur.data.movieDetailPathId
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class MovieApiTest {
    private lateinit var movieApi: MovieService
    private val mockWebServer = MockWebServer()

    @Before
    fun setup() {
        mockWebServer.start(8080)
        movieApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MovieService::class.java)
    }

    /**
     *  TOP RATED MOVIE
     */

    @Test
    fun `when movie api top rated response is not null`() = runBlocking {
        mockWebServer.enqueueMockResponse(TOP_RATED_MOVIE_RESPONSE_FILE_NAME)
        val response = movieApi.fetchTopRatedMovies(page = PAGE_NUM)
        assertThat(response).isNotNull()
    }

    @Test
    fun `requestPath when top rated movie requested is the same request`() = runBlocking {
        mockWebServer.enqueueMockResponse(TOP_RATED_MOVIE_RESPONSE_FILE_NAME)
        movieApi.fetchTopRatedMovies(page = PAGE_NUM)
        val request = mockWebServer.takeRequest()
        assertThat(request.path)
            .isEqualTo("/movie/top_rated?language=en-US&page=1")
    }

    @Test
    fun `when the top rated movie first element the same with the requested`() = runBlocking {
        mockWebServer.enqueueMockResponse(TOP_RATED_MOVIE_RESPONSE_FILE_NAME)
        val response = movieApi.fetchTopRatedMovies(page = PAGE_NUM)
        val firstMovieName = response.results.first().title
        assertThat(firstMovieName).isEqualTo("The Godfather")
    }

    /**
     *  MOVIE DETAIL
     */

    @Test
    fun `when movie api movie detail response is not null`() = runBlocking {
        mockWebServer.enqueueMockResponse(MOVIE_DETAIL_RESPONSE_FILE_NAME)
        val response = movieApi.fetchMovieById(id = movieDetailPathId)
        assertThat(response).isNotNull()
    }

    @Test
    fun `requestPath when movie detail requested is the same request`() = runBlocking {
        mockWebServer.enqueueMockResponse(MOVIE_DETAIL_RESPONSE_FILE_NAME)
        movieApi.fetchMovieById(id = movieDetailPathId)
        val request = mockWebServer.takeRequest()
        assertThat(request.path)
            .isEqualTo("/movie/$movieDetailPathId?language=en-US")
    }

    @Test
    fun `when the movie detail element the same with the requested`() = runBlocking {
        mockWebServer.enqueueMockResponse(MOVIE_DETAIL_RESPONSE_FILE_NAME)
        val response = movieApi.fetchMovieById(id = movieDetailPathId)
        val firstMovieName = response.body()?.title
        assertThat(firstMovieName).isEqualTo("The Godfather Part II")
    }

    @After
    fun shotDown() {
        mockWebServer.shutdown()
    }
}