package com.muhammetkudur.domain.di

import com.muhammetkudur.domain.usecase.detailmovieusecase.GetMovieDetailUseCase
import com.muhammetkudur.domain.usecase.detailmovieusecase.GetMovieDetailUseCaseImpl
import com.muhammetkudur.domain.usecase.topratedusecase.GetTopRatedMoviesUseCase
import com.muhammetkudur.domain.usecase.topratedusecase.GetTopRatedMoviesUseCaseImpl
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

    @Binds
    @ViewModelScoped
    abstract fun bindDetailMovieUseCase(getMovieDetailUseCaseImpl: GetMovieDetailUseCaseImpl): GetMovieDetailUseCase
}