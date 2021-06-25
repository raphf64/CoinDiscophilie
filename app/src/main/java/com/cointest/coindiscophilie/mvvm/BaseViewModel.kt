package com.cointest.coindiscophilie.mvvm

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancelChildren


open class BaseViewModel : ViewModel() {

    //Public Properties

    var isInitialized = ObservableBoolean(false)
        protected set

    //end

    //BaseViewModel Lifecycle

    open fun initialize() {}

    //end

    //Public Methods

    open fun cleanup() {
        cancelJobs()
    }

    //end

    //Private Methods

    private fun cancelJobs() {
        viewModelScope.coroutineContext.cancelChildren()
    }

    //end

    //ViewModel Implementation

    override fun onCleared() {
        cleanup()
    }

    //end
}
