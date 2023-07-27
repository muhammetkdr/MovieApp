package com.muhammetkudur.detail.mapper

import com.muhammetkudur.domain.mapper.Mapper
import com.muhammetkudur.domain.model.MovieDetailEntity
import com.muhammetkudur.ui.model.MovieDetailUiData
import javax.inject.Inject

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class MovieDetailUiDataMapperImpl @Inject constructor() :Mapper<MovieDetailEntity,MovieDetailUiData> {
    override fun map(input: MovieDetailEntity): MovieDetailUiData {
        return MovieDetailUiData(
            title = input.title,
            posterUrl = input.posterUrl,
            overview = input.overview
        )
    }
}