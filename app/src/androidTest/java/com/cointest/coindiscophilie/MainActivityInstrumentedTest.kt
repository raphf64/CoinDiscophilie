package com.cointest.coindiscophilie

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.cointest.coindiscophilie.views.MainActivity
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest{

    @Rule
    @JvmField
    var activityTestRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.cointest.coindiscophilie", appContext.packageName)
    }

}