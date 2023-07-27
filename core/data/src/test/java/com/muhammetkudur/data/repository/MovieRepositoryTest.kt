package com.muhammetkudur.data.repository

import app.cash.turbine.test
import com.google.common.truth.Truth
import com.muhammetkudur.common.networkresponse.NetworkResponse
import com.muhammetkudur.data.api.MovieService
import com.muhammetkudur.data.mapper.MovieDetailEntityMapperImpl
import com.muhammetkudur.data.mapper.TopRatedMovieEntityMapperImpl
import com.muhammetkudur.data.mockMovieDetailResponse
import com.muhammetkudur.data.movieDetailPathId
import com.muhammetkudur.data.source.remote.MovieRemoteDataSource
import com.muhammetkudur.data.source.remote.MovieRemoteDataSourceImpl
import com.muhammetkudur.domain.repository.MovieRepository
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

class MovieRepositoryTest {

    @Mock
    private lateinit var movieService: MovieService

    private lateinit var remoteDataSource: MovieRemoteDataSource
    private lateinit var movieRepository: MovieRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        remoteDataSource = MovieRemoteDataSourceImpl(movieService, Dispatchers.Unconfined)
        movieRepository = MovieRepositoryImpl(
            movieRemoteDataSource = remoteDataSource,
            movieMapper = TopRatedMovieEntityMapperImpl(),
            detailMovieMapper = MovieDetailEntityMapperImpl()
        )
    }

    @Test
    fun `movie detail response when api return success is response state success`() {
        runBlocking {
            Mockito.`when`(movieService.fetchMovieById(movieDetailPathId))
                .thenReturn(mockMovieDetailResponse)
            movieRepository.fetchMovieById(movieDetailPathId).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun `movie detail response when api return error is response state error`() {
        runBlocking {
            Mockito.`when`(movieService.fetchMovieById(movieDetailPathId)).thenReturn(null)
            movieRepository.fetchMovieById(movieDetailPathId).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Error::class.java)
                awaitComplete()
            }
        }
    }


    // TODO TEST Dispatcher eklenecek
/*    @Test
    fun `top rated movie response when api return success is response state success`() {
        runBlocking {
            Mockito.`when`(movieService.fetchTopRatedMovies(page = PAGE_NUM))
                .thenReturn(testTopRatedMovieResponse)
            movieRepository.fetchTopRatedMovies().test {
                Truth.assertThat(awaitItem()).isInstanceOf(PagingData.from(testTopRatedMovieEntityList)::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun `top rated movie response when api return error is response state error`() {
        runBlocking {
            Mockito.`when`(movieService.fetchTopRatedMovies(page = PAGE_NUM))
                .thenReturn(null)
            movieRepository.fetchTopRatedMovies().test {
                Truth.assertThat(awaitItem()).isNotInstanceOf(PagingData.from(testTopRatedMovieEntityList)::class.java)
                awaitComplete()
            }
        }
    }*/

}