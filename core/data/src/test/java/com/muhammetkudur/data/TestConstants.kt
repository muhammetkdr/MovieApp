package com.muhammetkudur.data

import androidx.annotation.VisibleForTesting
import com.muhammetkudur.data.dto.Movie
import com.muhammetkudur.data.dto.MovieResponse
import com.muhammetkudur.domain.model.MovieDetailEntity
import com.muhammetkudur.domain.model.TopRatedMovieEntity
import retrofit2.Response

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

const val TOP_RATED_MOVIE_RESPONSE_FILE_NAME = "TopRatedMovieResponse.json"
const val MOVIE_DETAIL_RESPONSE_FILE_NAME = "MovieDetailResponse.json"

@VisibleForTesting
const val PAGE_NUM = 1

@VisibleForTesting
const val movieDetailPathId = 240

@VisibleForTesting
val testTopRatedMovieDTO =
    Movie(
        title = "The Godfather",
        posterUrl = "/3bhkrj58Vtu7enYsRolD1fZdja1.jpg",
        popularity = 133.253,
        overview = "Spanning the years 1945 to 1955, a chronicle of the fictional Italian-American Corleone crime family. When organized crime family patriarch, Vito Corleone barely survives an attempt on his life, his youngest son, Michael steps in to take care of the would-be killers, launching a campaign of bloody revenge.",
        releaseDate = null,
        id = 238
    )

@VisibleForTesting
val testTopRatedMovieResponse = MovieResponse(
    page = PAGE_NUM
    ,listOf(
        testTopRatedMovieDTO
    )
)

@VisibleForTesting
val testMovieDetailDTO = Movie(
    title = "The Godfather Part II",
    posterUrl = "/bMadFzhjy9T7R8J48QGq1ngWNAK.jpg",
    popularity = null,
    overview = "In the continuing saga of the Corleone crime family, a young Vito Corleone grows up in Sicily and in 1910s New York. In the 1950s, Michael Corleone attempts to expand the family business into Las Vegas, Hollywood and Cuba.",
    releaseDate = null,
    id = 240
)

@VisibleForTesting
val mockMovieDetailResponse: Response<Movie> = Response.success(testMovieDetailDTO)

@VisibleForTesting
val testTopRatedMovieEntity = TopRatedMovieEntity(
    title = "The Godfather",
    posterUrl = "/3bhkrj58Vtu7enYsRolD1fZdja1.jpg",
    overview = "Spanning the years 1945 to 1955, a chronicle of the fictional Italian-American Corleone crime family. When organized crime family patriarch, Vito Corleone barely survives an attempt on his life, his youngest son, Michael steps in to take care of the would-be killers, launching a campaign of bloody revenge.",
    id = 238
)

@VisibleForTesting
val testTopRatedMovieEntityList = listOf(testTopRatedMovieEntity)

@VisibleForTesting
val testTopRatedMovieList = listOf(testMovieDetailDTO)

@VisibleForTesting
val testMovieDetailEntity = MovieDetailEntity(
    title = "The Godfather Part II",
    posterUrl = "/bMadFzhjy9T7R8J48QGq1ngWNAK.jpg",
    overview = "In the continuing saga of the Corleone crime family, a young Vito Corleone grows up in Sicily and in 1910s New York. In the 1950s, Michael Corleone attempts to expand the family business into Las Vegas, Hollywood and Cuba."
)




