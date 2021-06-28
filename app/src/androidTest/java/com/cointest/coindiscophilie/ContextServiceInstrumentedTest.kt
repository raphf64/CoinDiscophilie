package com.cointest.coindiscophilie

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.cointest.coindiscophilie.mvvm.IoC
import com.cointest.coindiscophilie.services.ContextService
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ContextServiceInstrumentedTest {

    @Before
    fun initContextServiceInstrumentedTest() {
        IoC.reset()
        IoC.registration { ContextService(InstrumentationRegistry.getInstrumentation().targetContext) }
    }

    @Test
    fun contextServiceInstrumentedTest() {
        assertEquals(true, IoC.injection<ContextService>().get() == InstrumentationRegistry.getInstrumentation().targetContext)
    }

    @After
    fun cleanContextServiceInstrumentedTest() {
        IoC.reset()
    }

}