package com.muhammetkudur.data.mapper

import com.muhammetkudur.common.ONE_VALUE
import com.muhammetkudur.data.dto.Movie
import com.muhammetkudur.domain.mapper.Mapper
import com.muhammetkudur.domain.model.TopRatedMovieEntity
import javax.inject.Inject

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class TopRatedMovieEntityMapperImpl @Inject constructor() :
    Mapper<Movie, TopRatedMovieEntity> {
    override fun map(input: Movie): TopRatedMovieEntity {
        return TopRatedMovieEntity(
            title = input.title.orEmpty(),
            posterUrl = input.posterUrl.orEmpty(),
            overview = input.overview.orEmpty(),
            id = input.id ?: Int.ONE_VALUE
        )
    }
}