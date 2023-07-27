package com.muhammetkudur.data.repository

import androidx.paging.PagingData
import app.cash.turbine.test
import com.google.common.truth.Truth
import com.muhammetkudur.common.networkresponse.NetworkResponse
import com.muhammetkudur.data.movieDetailPathId
import com.muhammetkudur.data.testTopRatedMovieEntityList
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class FakeMovieRepositoryTest {

    private val fakeMovieRepository = FakeMovieRepository()

    @Test
    fun movieDetailResponse_whenRemoteDataSourceReturnSuccess_returnSuccess(){
        runBlocking {
            fakeMovieRepository.fetchMovieById(movieDetailPathId).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun movieDetailResponse_whenRemoteDataSourceReturnError_returnError(){
        runBlocking {
            fakeMovieRepository.updateShowErrorForMovieDetail(true)
            fakeMovieRepository.fetchMovieById(movieDetailPathId).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Error::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun topRatedMovieResponse_whenRemoteDataSourceReturnSucces_returnData(){
        runBlocking {
            fakeMovieRepository.fetchTopRatedMovies().test {
                Truth.assertThat(awaitItem()).isInstanceOf(PagingData.from(testTopRatedMovieEntityList)::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun topRatedMovieResponse_whenRemoteDataSourceReturnError_returnEmpty(){
        runBlocking {
            fakeMovieRepository.updateShowErrorForTopRatedMovies(true)
            fakeMovieRepository.fetchTopRatedMovies().test {
                Truth.assertThat(awaitItem()).isInstanceOf(PagingData.from(emptyList())::class.java)
                awaitComplete()
            }
        }
    }

}