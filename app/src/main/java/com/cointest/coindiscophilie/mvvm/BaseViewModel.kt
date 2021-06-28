package com.cointest.coindiscophilie.mvvm

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancelChildren


open class BaseViewModel : ViewModel() {

    //region - Public Properties

    var isInitialized = ObservableBoolean(false)
        protected set

    //endregion

    //region - BaseViewModel Lifecycle

    open fun onInitialize() {}

    //endregion

    //region - Public Methods

    open fun cleanup() {
        cancelJobs()
    }

    //endregion

    //region - Private Methods

    private fun cancelJobs() {
        viewModelScope.coroutineContext.cancelChildren()
    }

    //endregion

    //region - ViewModel Implementation

    override fun onCleared() {
        cleanup()
    }

    //endregion
}
