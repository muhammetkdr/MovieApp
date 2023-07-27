package com.muhammetkudur.data.mapper

import com.google.common.truth.Truth
import com.muhammetkudur.data.testMovieDetailDTO
import com.muhammetkudur.domain.model.MovieDetailEntity
import org.junit.Before
import org.junit.Test

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class MovieDetailMapperTest {

    private lateinit var movieDetailEntityMapper: MovieDetailEntityMapperImpl
    private lateinit var movieDetailEntity: MovieDetailEntity

    @Before
    fun setup() {
        movieDetailEntityMapper = MovieDetailEntityMapperImpl()
        movieDetailEntity = movieDetailEntityMapper.map(testMovieDetailDTO)
    }

    @Test
    fun when_movie_overview_is_mapped() {
        Truth.assertThat(movieDetailEntity.overview).isEqualTo(testMovieDetailDTO.overview)
    }

    @Test
    fun when_movie_title_is_mapped() {
        Truth.assertThat(movieDetailEntity.title).isEqualTo(testMovieDetailDTO.title)
    }

    @Test
    fun when_movie_posterurl_is_mapped() {
        Truth.assertThat(movieDetailEntity.posterUrl).isEqualTo(testMovieDetailDTO.posterUrl)
    }
}