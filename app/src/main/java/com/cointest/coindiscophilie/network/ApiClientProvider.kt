package com.cointest.coindiscophilie.network

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


class ApiClientProvider {

    //region - Public Methods

    fun getApiClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .cache(null)
            .addNetworkInterceptor { chain ->
                chain.proceed(
                    chain.request()
                        .newBuilder()
                        .build()
                )
            }
            .readTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .build()
    }

    //endregion

}