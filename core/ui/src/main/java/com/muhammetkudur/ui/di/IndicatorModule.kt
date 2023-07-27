package com.muhammetkudur.ui.di

import android.content.Context
import com.muhammetkudur.ui.utils.indicator.DefaultIndicatorPresenter
import com.muhammetkudur.ui.utils.indicator.IndicatorPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

@Module
@InstallIn(ActivityComponent::class)
object PresentationModule {

    @Provides
    @ActivityScoped
    fun provideIndicatorPresenter(@ActivityContext context: Context): IndicatorPresenter = DefaultIndicatorPresenter(context)

}