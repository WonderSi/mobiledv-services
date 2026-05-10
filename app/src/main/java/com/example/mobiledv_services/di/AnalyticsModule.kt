package com.example.mobiledv_services.di

import com.example.core.analytics.AnalyticsService
import com.example.mobiledv_services.analytics.AppMetricaAnalyticsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AnalyticsModule {

    @Provides
    @Singleton
    fun provideAnalyticsService(): AnalyticsService = AppMetricaAnalyticsService()
}
