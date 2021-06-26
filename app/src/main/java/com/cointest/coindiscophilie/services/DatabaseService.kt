package com.cointest.coindiscophilie.services

import android.content.Context
import com.cointest.coindiscophilie.database.AppDataBase
import com.cointest.coindiscophilie.database.TitleEntity
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
        val title = (TitleEntity()).also {
            it.albumId = titleEntry.albumId
            it.id = titleEntry.id
            it.title = titleEntry.title
            it.url = titleEntry.url
            it.thumbnailUrl = titleEntry.thumbnailUrl
        }

        return runSafeDatabaseCall {
            database.titleDao.upsert(title)
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
