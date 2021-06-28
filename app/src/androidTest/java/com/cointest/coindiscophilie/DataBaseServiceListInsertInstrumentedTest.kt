package com.cointest.coindiscophilie

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.cointest.coindiscophilie.models.TitleEntity
import com.cointest.coindiscophilie.services.DatabaseService
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DataBaseServiceListInsertInstrumentedTest {

    @Rule
    @JvmField
    var databaseService = DatabaseService(InstrumentationRegistry.getInstrumentation().targetContext)

    @Before
    fun initDataBaseServiceListInsertInstrumentedTest() {
        runBlocking {
            databaseService.createOrUpdateTitles(
                listOf(
                    TitleEntity(albumId = 1, title = "title", id = 1, url = "", thumbnailUrl = ""),
                    TitleEntity(albumId = 1, title = "title1", id = 2, url = "", thumbnailUrl = ""),
                    TitleEntity(albumId = 1, title = "title2", id = 3, url = "", thumbnailUrl = ""),
                    TitleEntity(albumId = 1, title = "title3", id = 4, url = "", thumbnailUrl = ""),
                    TitleEntity(albumId = 1, title = "title4", id = 5, url = "", thumbnailUrl = "")
                )
            )
        }
    }

    @Test
    fun databaseServiceListInsertInstrumentedTest() {
        runBlocking {
            assertEquals(true, databaseService.getTitle(1).title == "title")
            assertEquals(true, databaseService.getTitle(2).title == "title1")
            assertEquals(true, databaseService.getTitle(3).title == "title2")
            assertEquals(true, databaseService.getTitle(4).title == "title3")
            assertEquals(true, databaseService.getTitle(5).title == "title4")
        }
    }

    @After
    fun databaseServiceResetInstrumentedTest() {
        runBlocking {
            databaseService.deleteAll()
        }
    }

}