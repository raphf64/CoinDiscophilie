package com.cointest.coindiscophilie

import android.app.Application
import com.cointest.coindiscophilie.mvvm.IoC
import com.cointest.coindiscophilie.services.DatabaseService

class CoinDiscophilieApp: Application() {

    //Application Lifecycle

    override fun onCreate() {
        super.onCreate()
        IoC.registerSingleton { DatabaseService(applicationContext) }
    }

    //end
}