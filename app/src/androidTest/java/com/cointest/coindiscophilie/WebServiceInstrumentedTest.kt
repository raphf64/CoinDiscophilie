package com.cointest.coindiscophilie

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cointest.coindiscophilie.models.TitleEntity
import com.cointest.coindiscophilie.services.WebService
import io.reactivex.Observable
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class WebServiceInstrumentedTest {

    var webService = WebService()
    lateinit var response:Observable<List<TitleEntity>>

    @Before
    fun initWebServiceUnitTest() {
        runBlocking {
            response = webService.getTitles()
        }
    }

    @Test
    fun webServiceResponseTest() {
        runBlocking {
            response.subscribe({
                assertEquals(true,it.count() != 0)
            },{
                assert(false)
            })
        }
    }

}