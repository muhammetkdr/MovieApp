package com.muhammetkudur.detail.di

import com.muhammetkudur.detail.mapper.MovieDetailUiDataMapperImpl
import com.muhammetkudur.domain.mapper.Mapper
import com.muhammetkudur.domain.model.MovieDetailEntity
import com.muhammetkudur.ui.model.MovieDetailUiData
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
abstract class DetailUiMapperModule {

        @Binds
        @ViewModelScoped
        abstract fun bindMovieDetailEntityToUiMapper(movieDetailUiDataMapperImpl: MovieDetailUiDataMapperImpl ): Mapper<MovieDetailEntity,MovieDetailUiData >

}