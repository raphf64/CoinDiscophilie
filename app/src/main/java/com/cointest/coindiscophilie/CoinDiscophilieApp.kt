package com.cointest.coindiscophilie

import android.app.Application
import android.content.Context
import com.cointest.coindiscophilie.mvvm.IoC
import com.cointest.coindiscophilie.services.ContextService
import com.cointest.coindiscophilie.services.DatabaseService
import com.cointest.coindiscophilie.services.WebService


class CoinDiscophilieApp: Application() {

    //region - Application Lifecycle

    override fun onCreate() {
        super.onCreate()
        IoC.registration { DatabaseService(applicationContext) }
        IoC.registration { WebService(applicationContext) }
        IoC.registration { ContextService(applicationContext) }
    }

    //endregion

}