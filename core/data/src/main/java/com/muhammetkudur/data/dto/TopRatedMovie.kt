package com.muhammetkudur.data.dto

import com.squareup.moshi.Json

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

data class TopRatedMovie(
    @field:Json(name = "original_title") val title: String?,
    @field:Json(name = "poster_path") val posterUrl: String?,
    @field:Json(name = "popularity") val popularity: Double?,
    @field:Json(name = "overview") val overview: String?,
    @field:Json(name ="release_date") val releaseDate: String?,
    @field:Json(name = "id") val id: Int?
)