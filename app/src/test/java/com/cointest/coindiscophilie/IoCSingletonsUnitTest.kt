package com.cointest.coindiscophilie

import com.cointest.coindiscophilie.mvvm.IoC
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class IoCSingletonsUnitTest {

    @Before
    fun initSingletonsCreationTest() {
        IoC.registerSingleton<IFoo> { Foo() }
    }

    @Test
    fun singletonsCreationTest() {
        val testSingleton1 = IoC.resolve<IFoo>()
        val testSingleton2 = IoC.resolve<IFoo>()

        assertEquals(true, testSingleton1 == testSingleton2)
    }

    @After
    fun resetIoc() {
        IoC.reset()
    }

}