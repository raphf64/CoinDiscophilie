package com.cointest.coindiscophilie.services

import android.content.Context
import com.cointest.coindiscophilie.database.AppDataBase
import com.cointest.coindiscophilie.models.TitleEntity
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement


class DatabaseService(applicationContext: Context): TestRule {


    //region - Private Members

    private val database = AppDataBase.getInstance(applicationContext, "CoinDiscophilieDB")

    //endregion

    //region - Private Methods

    private suspend fun runSafeDatabaseCall(call: suspend () -> Unit): Boolean {
        return try {
            call()
            true
        } catch (exception: Exception) {
            exception.printStackTrace()
            false
        }
    }

    //endregion

    //region - Public Methods

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

    suspend fun deleteAll(): Boolean  {
        return runSafeDatabaseCall {
            database.titleDao.deleteAll()
        }
    }

    suspend fun getTitle(id: Int): TitleEntity {
        return database.titleDao.getTitle(id)
    }

    suspend fun getTitles(): List<TitleEntity> {
        return database.titleDao.getTitles()
    }

    override fun apply(base: Statement?, description: Description?): Statement {
        return base!!
    }

    //endregion

}
