package com.cointest.coindiscophilie.mvvm

import kotlin.reflect.KClass


data class Registration(val named: String, val instance: KClass<*>)

object IoC {

    //region - Private Members

    private val container = mutableMapOf<Registration, Lazy<*>>()

    //endregion

    //region - Public Methods

    inline fun <reified T> registration(named: String = "", noinline instance: () -> T): Registration = synchronized(this) {
        val registration = Registration(named, T::class)
        val lazyInstance = lazy(this, instance)
        recordRegistrationInstance(registration, lazyInstance)
        registration
    }

    fun reset() = synchronized(this) {
        container.clear()
    }

    fun getInstance(registration: Registration): Lazy<*>? {
        check(container.containsKey(registration)){"No instance with this registration"}
        return container[registration]
    }

    inline fun <reified T> injection(named: String = ""): T {
        val registration = Registration(named, T::class)
        val myObject = checkNotNull(getInstance(registration)) {
            "${registration.instance}" +
                (if (registration.named.isNotBlank()) " named ${registration.named}" else "") +
                    " is not registered in the IoC container"
        }
        return myObject.value as T
    }

    fun <T> recordRegistrationInstance(registration: Registration, instance: Lazy<T>) {
        check(!container.containsKey(registration)){"Already 1 instance with the same registration"}
        container[registration] = instance
    }

    //endregion


}
