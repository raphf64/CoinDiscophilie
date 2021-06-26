package com.cointest.coindiscophilie

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.cointest.coindiscophilie.database.TitleEntity
import com.cointest.coindiscophilie.services.DatabaseService
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DataBaseServiceUnitTest {

    @Rule
    @JvmField
    var databaseService = DatabaseService(InstrumentationRegistry.getInstrumentation().targetContext)

    @Before
    fun initDataBaseServiceUnitTest() {
        runBlocking {
            databaseService.createOrUpdateTitle(TitleEntity(albumId = 1, title = "title", id = 1, url = "", thumbnailUrl = ""))
        }
    }

    @Test
    fun dataBaseInsertTest() {
        runBlocking {
            assertEquals(true, databaseService.getTitle(1).title == "title")
        }
    }

}