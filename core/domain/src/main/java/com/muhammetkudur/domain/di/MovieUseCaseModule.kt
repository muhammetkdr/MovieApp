package com.muhammetkudur.domain.di

import com.muhammetkudur.domain.usecase.GetTopRatedMoviesUseCase
import com.muhammetkudur.domain.usecase.GetTopRatedMoviesUseCaseImpl
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
abstract class MovieUseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindMovieTopRatedMoviesUseCase(getTopRatedMoviesUseCaseImpl: GetTopRatedMoviesUseCaseImpl): GetTopRatedMoviesUseCase

}