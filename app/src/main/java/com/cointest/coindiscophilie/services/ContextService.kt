package com.cointest.coindiscophilie.services

import android.content.Context
import java.lang.ref.WeakReference

class ContextService(private val context: Context) {

    //region - Public members

    var rootView: WeakReference<Any> = WeakReference(Any())

    //endregion

    //region - Public methods

    fun get(): Context = context


    //endregion

}
