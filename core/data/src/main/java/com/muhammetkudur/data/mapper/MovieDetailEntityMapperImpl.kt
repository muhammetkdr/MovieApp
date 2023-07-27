package com.muhammetkudur.data.mapper

import com.muhammetkudur.data.dto.Movie
import com.muhammetkudur.domain.mapper.Mapper
import com.muhammetkudur.domain.model.MovieDetailEntity
import javax.inject.Inject

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class MovieDetailEntityMapperImpl @Inject constructor() : Mapper<Movie, MovieDetailEntity> {
    override fun map(input: Movie): MovieDetailEntity {
        return MovieDetailEntity(
            title = input.title.orEmpty(),
            posterUrl = input.posterUrl.orEmpty(),
            overview = input.overview.orEmpty()
        )
    }
}