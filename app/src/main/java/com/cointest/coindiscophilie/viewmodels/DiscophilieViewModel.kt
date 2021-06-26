package com.cointest.coindiscophilie.viewmodels

import android.os.Handler
import androidx.databinding.ObservableField
import com.cointest.coindiscophilie.mvvm.BaseViewModel


class DiscophilieViewModel: BaseViewModel() {

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