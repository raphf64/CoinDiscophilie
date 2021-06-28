package com.cointest.coindiscophilie.viewmodels

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.viewModelScope
import com.cointest.coindiscophilie.mvvm.BaseViewModel
import com.cointest.coindiscophilie.mvvm.IoC
import com.cointest.coindiscophilie.services.DatabaseService
import com.cointest.coindiscophilie.services.WebService
import kotlinx.coroutines.launch


class DiscophilieViewModel: BaseViewModel() {

    //region - Services Injection

    private val databaseService: DatabaseService
        get() = IoC.injection()

    private val webService: WebService
        get() = IoC.injection()

    //endregion

    //region - Public Members

    val items = ObservableArrayList<DiscItemViewModel>()

    //endregion

    //region - BaseViewModel Lifecycle

    override fun onInitialize() {
        super.onInitialize()

        getDiscophilie()
    }

    //endregion

    //region - Private Methods

    private fun getDiscophilie() {
        viewModelScope.launch {
            val response = webService.getTitles()
            response.subscribe({ list ->
                viewModelScope.launch {
                    databaseService.createOrUpdateTitles(list)
                    getDiscophilieFromDB()
                    isInitialized.set(true)
                }
            },{
                getDiscophilieFromDB()
            })
        }
    }

    private fun getDiscophilieFromDB() {
        viewModelScope.launch {
            items.addAll(databaseService.getTitles().map { it.toViewModel() })
            isInitialized.set(true)
        }
    }

    //endregion

}