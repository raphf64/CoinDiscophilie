package com.cointest.coindiscophilie.services

import android.content.Context
import com.cointest.coindiscophilie.CoinDiscophilieApp
import com.cointest.coindiscophilie.models.TitleEntity
import com.cointest.coindiscophilie.network.ApiClientProvider
import com.cointest.coindiscophilie.network.ApiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class WebService(context: Context) : TestRule {

    // Private Members

    private val apiService : ApiService = Retrofit.Builder()
        .baseUrl( (context.applicationContext as CoinDiscophilieApp).getBaseUrl() )
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(ApiClientProvider().getApiClient(context))
        .build()
        .create(ApiService::class.java)

    //end

    // Public Methods

    fun getTitles(): Observable<List<TitleEntity>> {
        return apiService.welcome()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }

    //end

    //TestRule implementation

    override fun apply(base: Statement?, description: Description?): Statement {
        return base!!
    }

    //end

}