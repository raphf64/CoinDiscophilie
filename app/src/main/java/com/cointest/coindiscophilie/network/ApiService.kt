package com.cointest.coindiscophilie.network

import com.cointest.coindiscophilie.models.TitleEntity
import retrofit2.http.GET
import io.reactivex.Observable


interface ApiService {

    @GET("/img/shared/technical-test.json")
    fun welcome(): Observable<List<TitleEntity>>
}