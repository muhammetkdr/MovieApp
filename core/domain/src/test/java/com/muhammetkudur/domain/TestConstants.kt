package com.muhammetkudur.domain

import androidx.annotation.VisibleForTesting
import com.muhammetkudur.domain.model.MovieDetailEntity
import com.muhammetkudur.domain.model.TopRatedMovieEntity

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

@VisibleForTesting
const val movieDetailPathId = 240

@VisibleForTesting
val testTopRatedMovieEntity = TopRatedMovieEntity(
    title = "The Godfather",
    posterUrl = "/3bhkrj58Vtu7enYsRolD1fZdja1.jpg",
    overview = "Spanning the years 1945 to 1955, a chronicle of the fictional Italian-American Corleone crime family. When organized crime family patriarch, Vito Corleone barely survives an attempt on his life, his youngest son, Michael steps in to take care of the would-be killers, launching a campaign of bloody revenge.",
    id = 238
)

@VisibleForTesting
val testTopRatedMovieEntityList = listOf(testTopRatedMovieEntity)

val testMovieDetailEntity = MovieDetailEntity(
    title = "The Godfather Part II",
    posterUrl = "/bMadFzhjy9T7R8J48QGq1ngWNAK.jpg",
    overview = "In the continuing saga of the Corleone crime family, a young Vito Corleone grows up in Sicily and in 1910s New York. In the 1950s, Michael Corleone attempts to expand the family business into Las Vegas, Hollywood and Cuba."
)