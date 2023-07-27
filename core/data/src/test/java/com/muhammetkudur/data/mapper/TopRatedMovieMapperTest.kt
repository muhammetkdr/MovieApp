package com.muhammetkudur.data.mapper

import com.google.common.truth.Truth.assertThat
import com.muhammetkudur.data.testTopRatedMovieDTO
import com.muhammetkudur.domain.model.TopRatedMovieEntity
import org.junit.Before
import org.junit.Test

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class TopRatedMovieMapperTest {
    private lateinit var topRatedMovieEntityMapper: TopRatedMovieEntityMapperImpl
    private lateinit var topRatedMovieEntity: TopRatedMovieEntity

    @Before
    fun setup(){
        topRatedMovieEntityMapper = TopRatedMovieEntityMapperImpl()
        topRatedMovieEntity = topRatedMovieEntityMapper.map(testTopRatedMovieDTO)
    }

    @Test
    fun when_movie_id_is_mapped(){
        assertThat(topRatedMovieEntity.id).isEqualTo(testTopRatedMovieDTO.id)
    }

    @Test
    fun when_movie_overview_is_mapped(){
        assertThat(topRatedMovieEntity.overview).isEqualTo(testTopRatedMovieDTO.overview)
    }

    @Test
    fun when_movie_title_is_mapped(){
        assertThat(topRatedMovieEntity.title).isEqualTo(testTopRatedMovieDTO.title)
    }

    @Test
    fun when_movie_posterurl_is_mapped(){
        assertThat(topRatedMovieEntity.posterUrl).isEqualTo(testTopRatedMovieDTO.posterUrl)
    }
}