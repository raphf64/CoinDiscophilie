package com.cointest.coindiscophilie.viewmodels

import android.view.View
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.cointest.coindiscophilie.R
import com.cointest.coindiscophilie.models.TitleEntity
import com.cointest.coindiscophilie.mvvm.BaseViewModel
import com.cointest.coindiscophilie.mvvm.IoC
import com.cointest.coindiscophilie.services.ContextService
import com.cointest.coindiscophilie.services.DatabaseService
import com.cointest.coindiscophilie.services.WebService
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import java.net.UnknownHostException


class DiscophilieViewModel: BaseViewModel() {

    //region - Services Injection

    private val contextService: ContextService
        get() = IoC.injection()

    private val databaseService: DatabaseService
        get() = IoC.injection()

    private val webService: WebService
        get() = IoC.injection()

    //endregion

    //region - Public Members

    val items = ObservableArrayList<DiscItemViewModel>()

    val progressBarVisibility = ObservableField(false)

    //endregion

    //region - BaseViewModel Lifecycle

    override fun onInitialize() {
        super.onInitialize()

        getDiscophilie()
    }

    //endregion

    //region - Private Methods

    private fun getDiscophilie() {
        progressBarVisibility.set(true)
        viewModelScope.launch {
            val response = webService.getTitles()
            response.subscribe({ list ->
                manageResponse(list)
            },{
                manageErrors(it)
            })
        }
    }

    private fun manageResponse(list: List<TitleEntity>) {
        viewModelScope.launch {
            databaseService.createOrUpdateTitles(list)
            getDiscophilieFromDB()
            isInitialized.set(true)
            progressBarVisibility.set(false)
        }
    }

    private fun manageErrors(it: Throwable?) {
        viewModelScope.launch {
            if (dataOnDB()) getDiscophilieFromDB()
            else when (it) {
                is UnknownHostException -> Snackbar.make(
                    contextService.rootView.get() as View,
                    contextService.get()
                        .getString(R.string.discophilie_error_internet_connection_message),
                    Snackbar.LENGTH_LONG
                ).show()
                else -> Snackbar.make(
                    contextService.rootView.get() as View,
                    contextService.get().getString(R.string.discophilie_error_others_message),
                    Snackbar.LENGTH_LONG
                ).show()
            }
            isInitialized.set(true)
            progressBarVisibility.set(false)
        }
    }

    private fun getDiscophilieFromDB() {
        viewModelScope.launch {
            items.addAll(databaseService.getTitles().map { it.toViewModel() })
            isInitialized.set(true)
            progressBarVisibility.set(false)
        }
    }

    private suspend fun dataOnDB(): Boolean {
        return databaseService.titlesCount() != 0
    }

    //endregion

}