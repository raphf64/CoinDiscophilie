package com.cointest.coindiscophilie

import android.app.Application
import com.cointest.coindiscophilie.mvvm.IoC
import com.cointest.coindiscophilie.services.DatabaseService
import com.cointest.coindiscophilie.services.WebService


class CoinDiscophilieApp: Application() {

    //Application Lifecycle

    override fun onCreate() {
        super.onCreate()
        IoC.registerSingleton { DatabaseService(applicationContext) }
        IoC.registerSingleton { WebService(applicationContext) }
    }

    //end

    //Public Methods

    fun getBaseUrl(): String = BuildConfig.API_BASE_URL

    //end
}