package com.cointest.coindiscophilie

import com.cointest.coindiscophilie.mvvm.IoC
import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before


interface IFoo
class Foo : IFoo

class IoCNamedSingletonsUnitTest {

    @Before
    fun initNamedSingletonsCreationTest() {
        IoC.registration<IFoo>("singletonTest1") { Foo() }
        IoC.registration<IFoo>("singletonTest2") { Foo() }
    }

    @Test
    fun namedSingletonsCreationTest() {
        val testSingleton1 = IoC.injection<IFoo>("singletonTest1")
        val testSingleton2 = IoC.injection<IFoo>("singletonTest2")

        assertEquals(false, testSingleton1 == testSingleton2)
    }

    @After
    fun resetIoc() {
        IoC.reset()
    }

}