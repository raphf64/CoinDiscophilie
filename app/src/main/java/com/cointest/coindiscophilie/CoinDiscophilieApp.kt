package com.cointest.coindiscophilie

import android.app.Application
import com.cointest.coindiscophilie.mvvm.IoC
import com.cointest.coindiscophilie.services.ContextService
import com.cointest.coindiscophilie.services.DatabaseService
import com.cointest.coindiscophilie.services.WebService


class CoinDiscophilieApp: Application() {

    //region - Application Lifecycle

    override fun onCreate() {
        super.onCreate()
        IoC.registration { DatabaseService(applicationContext) }
        IoC.registration { WebService() }
        IoC.registration { ContextService(applicationContext) }
    }

    override fun onTerminate() {
        super.onTerminate()
        IoC.reset()
    }

    //endregion

}