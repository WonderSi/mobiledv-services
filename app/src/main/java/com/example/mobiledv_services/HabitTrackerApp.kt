package com.example.mobiledv_services

import android.app.Application
import com.example.mobiledv_services.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import io.appmetrica.analytics.AppMetrica
import io.appmetrica.analytics.AppMetricaConfig

@HiltAndroidApp
class HabitTrackerApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initAppMetrica()
    }

    private fun initAppMetrica() {
        val config = AppMetricaConfig
            .newConfigBuilder(BuildConfig.APPMETRICA_API_KEY)
            .withLogs()
            .withSessionTimeout(60)
            .build()
        AppMetrica.activate(applicationContext, config)
        AppMetrica.enableActivityAutoTracking(this)
    }
}
