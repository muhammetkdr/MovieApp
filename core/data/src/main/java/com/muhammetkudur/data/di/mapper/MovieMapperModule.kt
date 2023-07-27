package com.muhammetkudur.data.di.mapper

import com.muhammetkudur.data.dto.Movie
import com.muhammetkudur.data.mapper.MovieDetailEntityMapperImpl
import com.muhammetkudur.data.mapper.TopRatedMovieEntityMapperImpl
import com.muhammetkudur.domain.mapper.Mapper
import com.muhammetkudur.domain.model.MovieDetailEntity
import com.muhammetkudur.domain.model.TopRatedMovieEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class MovieMapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindTopRatedMovieResponseToEntity(
        topRatedMovieEntityMapperimpl: TopRatedMovieEntityMapperImpl
    ): Mapper<Movie, TopRatedMovieEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindDetailMovieResponseToEntity(
        movieDetailEntityMapperImpl: MovieDetailEntityMapperImpl
    ): Mapper<Movie, MovieDetailEntity>

}