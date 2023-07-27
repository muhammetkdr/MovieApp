package com.muhammetkudur.data.dto

import com.squareup.moshi.Json

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

data class MovieResponse(
    @field:Json(name = "page") val page: Int,
    @field:Json(name = "results") val results: List<Movie>
)