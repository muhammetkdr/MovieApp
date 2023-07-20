package com.muhammetkudur.home.di

import com.muhammetkudur.domain.mapper.Mapper
import com.muhammetkudur.domain.model.TopRatedMovieEntity
import com.muhammetkudur.home.mapper.HomeTopRatedUiDataMapperImpl
import com.muhammetkudur.ui.model.TopRatedMovieUiData
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
abstract class UiMapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindtopRatedEntityToUiMapper(topRatedUiDataMapperImpl: HomeTopRatedUiDataMapperImpl): Mapper<TopRatedMovieEntity, TopRatedMovieUiData>
}