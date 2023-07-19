package com.muhammetkudur.data.di.source.remote

import com.muhammetkudur.data.source.remote.MovieRemoteDataSource
import com.muhammetkudur.data.source.remote.MovieRemoteDataSourceImpl
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
abstract class MovieRemoteDataSourceModule {

    @Binds
    @ViewModelScoped
    abstract fun bindMovieRemoteDataSource(movieRemoteDataSourceImpl: MovieRemoteDataSourceImpl): MovieRemoteDataSource
}
