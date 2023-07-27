package com.muhammetkudur.domain.usecase.moviedetail

import app.cash.turbine.test
import com.google.common.truth.Truth
import com.muhammetkudur.common.networkresponse.NetworkResponse
import com.muhammetkudur.domain.movieDetailPathId
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class DetailMovieUseCaseTest {

    val fakeMovieDetailUseCase = FakeMovieDetailUseCase()

    @Test
    fun networkState_whenStateLoading_returnLoading() {
        runBlocking {
            fakeMovieDetailUseCase(id = movieDetailPathId).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @Test
    fun networkState_whenStateLoadingAndSuccess_returnLoadingAndSuccessSequentially() {
        runBlocking {
            fakeMovieDetailUseCase(id = movieDetailPathId).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun networkState_whenStateLoadingAndError_returnError() {
        runBlocking {
            fakeMovieDetailUseCase.updateShowError(true)
            fakeMovieDetailUseCase(id = movieDetailPathId).test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Error::class.java)
                awaitComplete()
            }
        }
    }
}