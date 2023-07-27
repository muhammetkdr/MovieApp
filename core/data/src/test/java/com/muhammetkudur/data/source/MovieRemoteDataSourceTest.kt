package com.muhammetkudur.data.source

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.muhammetkudur.common.networkresponse.NetworkResponse
import com.muhammetkudur.data.api.MovieService
import com.muhammetkudur.data.mockMovieDetailResponse
import com.muhammetkudur.data.movieDetailPathId
import com.muhammetkudur.data.source.remote.MovieRemoteDataSourceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class MovieRemoteDataSourceTest {

    @Mock
    private lateinit var movieService: MovieService

    private lateinit var movieRemoteDataSource: MovieRemoteDataSourceImpl

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        movieRemoteDataSource = MovieRemoteDataSourceImpl(movieService, Dispatchers.Unconfined)
    }

    @Test
    fun `when movie detail api request return success is response state success`() = runBlocking {
        Mockito.`when`(movieService.fetchMovieById(id = movieDetailPathId)).thenReturn(mockMovieDetailResponse)
        movieRemoteDataSource.fetchMovieById(movieDetailPathId).test {
            assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
            assertThat(awaitItem()).isInstanceOf(NetworkResponse.Success::class.java)
            awaitComplete()
        }
    }

    @Test
    fun `when  movie detail api request return null is response state error`() = runBlocking {
        Mockito.`when`(movieService.fetchMovieById(id = movieDetailPathId)).thenReturn(null)
        movieRemoteDataSource.fetchMovieById(movieDetailPathId).test {
            assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
            assertThat(awaitItem()).isInstanceOf(NetworkResponse.Error::class.java)
            awaitComplete()
        }
    }

    // TODO TEST Dispatcher eklenecek
/*    @Test
    fun `when top rated api request return success is response state success`() = runBlocking {
        Mockito.`when`(movieService.fetchTopRatedMovies(page = PAGE_NUM)).thenReturn(testTopRatedMovieResponse)
        movieRemoteDataSource.fetchTopRatedMovies().test {
            assertThat(awaitItem()).isInstanceOf(PagingData.from(testTopRatedMovieEntityList)::class.java)
            awaitComplete()
        }
    }

    @Test
    fun `when top rated api request return error is response state error`() = runBlocking {
        Mockito.`when`(movieService.fetchTopRatedMovies(page = PAGE_NUM)).thenReturn(null)
        movieRemoteDataSource.fetchTopRatedMovies().test {
            assertThat(awaitItem()).isNotInstanceOf(PagingData.from(testTopRatedMovieEntityList)::class.java)
            awaitComplete()
        }
    }*/
}