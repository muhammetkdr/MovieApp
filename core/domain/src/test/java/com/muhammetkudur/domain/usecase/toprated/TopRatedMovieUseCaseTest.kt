package com.muhammetkudur.domain.usecase.toprated

import androidx.paging.PagingData
import app.cash.turbine.test
import com.google.common.truth.Truth
import com.muhammetkudur.domain.testTopRatedMovieEntityList
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class TopRatedMovieUseCaseTest {

    val fakeTopRatedUseCase = FakeTopRatedUseCase()

    @Test
    fun networkState_whenStateSuccess_returnSuccess() {
        runBlocking {
            fakeTopRatedUseCase().test {
                Truth.assertThat(awaitItem()).isInstanceOf(PagingData.from(testTopRatedMovieEntityList)::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun networkState_whenStateError_returnError() {
        runBlocking {
            fakeTopRatedUseCase.updateShowError(true)
            fakeTopRatedUseCase().test {
                Truth.assertThat(awaitItem()).isInstanceOf(PagingData.from(emptyList())::class.java)
                awaitComplete()
            }
        }
    }
}