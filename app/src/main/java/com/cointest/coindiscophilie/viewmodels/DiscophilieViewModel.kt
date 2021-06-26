package com.cointest.coindiscophilie.viewmodels

import android.os.Handler
import androidx.databinding.ObservableField
import com.cointest.coindiscophilie.mvvm.BaseViewModel
import com.cointest.coindiscophilie.mvvm.IoC
import com.cointest.coindiscophilie.services.DatabaseService
import com.cointest.coindiscophilie.services.WebService


class DiscophilieViewModel: BaseViewModel() {

    //Services Injection

    private val databaseService: DatabaseService
        get() = IoC.resolve()

    private val webService: WebService
        get() = IoC.resolve()

    //end

    //Public Members

    val textView = ObservableField("Coucou")

    //end

    //BaseViewModel Implementation

    override fun initialize() {
        super.initialize()
        Handler().postDelayed(
            {
                textView.set("Au revoir")
            },
            3000
        )
        isInitialized.set(true)
    }

    //end
}