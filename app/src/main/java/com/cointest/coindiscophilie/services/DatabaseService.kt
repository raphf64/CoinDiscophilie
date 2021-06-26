package com.cointest.coindiscophilie.services

import android.content.Context
import com.cointest.coindiscophilie.database.AppDataBase
import com.cointest.coindiscophilie.models.TitleEntity
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement


class DatabaseService(applicationContext: Context): TestRule {


    //Private Members

    private val database = AppDataBase.getInstance(applicationContext, "CoinDiscophilieDB")

    //end

    //Private Methods

    private suspend fun runSafeDatabaseCall(call: suspend () -> Unit): Boolean {
        return try {
            call()
            true
        } catch (exception: Exception) {
            exception.printStackTrace()
            false
        }
    }

    //end

    //Public Methods

    suspend fun createOrUpdateTitle(titleEntry: TitleEntity): Boolean {
        return runSafeDatabaseCall {
            database.titleDao.upsert(titleEntry)
        }
    }

    suspend fun createOrUpdateTitles(titleEntries: List<TitleEntity>): Boolean {
        return runSafeDatabaseCall {
            database.titleDao.upsert(titleEntries)
        }
    }

    suspend fun getTitle(id: Int): TitleEntity {
        return database.titleDao.getTitle(id)
    }

    override fun apply(base: Statement?, description: Description?): Statement {
        return base!!
    }

    //end

}
