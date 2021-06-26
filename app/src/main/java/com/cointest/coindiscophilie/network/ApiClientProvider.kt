package com.cointest.coindiscophilie.network

import android.content.Context
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


class ApiClientProvider {

    fun getApiClient(context: Context): OkHttpClient {

        return OkHttpClient.Builder()
            .cache(null)
            //.addInterceptor(NetworkInterceptor(context))
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
}