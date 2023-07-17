package com.muhammetkudur.data.dto

import com.squareup.moshi.Json

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

data class Movie(
    @field:Json(name = "original_title") val title: String,
    @field:Json(name = "poster_path") val posterUrl: String?,
    @field:Json(name = "popularity") val popularity: Double?
)