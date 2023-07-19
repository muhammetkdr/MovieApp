package com.muhammetkudur.data.mapper

import com.muhammetkudur.common.EMPTY
import com.muhammetkudur.data.dto.TopRatedMovie
import com.muhammetkudur.domain.mapper.Mapper
import com.muhammetkudur.domain.model.TopRatedMovieEntity
import javax.inject.Inject

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class TopRatedMovieEntityMapperImpl @Inject constructor() :
    Mapper<TopRatedMovie, TopRatedMovieEntity> {
    override fun map(input: TopRatedMovie): TopRatedMovieEntity {
        return TopRatedMovieEntity(
            title = input.title ?: String.EMPTY,
            posterUrl = input.posterUrl ?: String.EMPTY,
            overview = input.overview ?: String.EMPTY
        )
    }
}