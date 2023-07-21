package com.muhammetkudur.home.mapper

import com.muhammetkudur.domain.mapper.Mapper
import com.muhammetkudur.domain.model.TopRatedMovieEntity
import com.muhammetkudur.ui.model.TopRatedMovieUiData
import javax.inject.Inject

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class HomeTopRatedUiDataMapperImpl @Inject constructor() : Mapper<TopRatedMovieEntity,TopRatedMovieUiData> {
    override fun map(input: TopRatedMovieEntity): TopRatedMovieUiData {
        return TopRatedMovieUiData(
            title = input.title,
            posterUrl = input.posterUrl,
            overview = input.overview,
            id = input.id
        )
    }
}