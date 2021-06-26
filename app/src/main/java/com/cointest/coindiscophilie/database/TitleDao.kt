package com.cointest.coindiscophilie.database

import androidx.room.*

@Dao
internal interface TitleDao: DaoBase<TitleEntity> {

    @Query("DELETE FROM Title")
    suspend fun deleteAll()

    @Query("SELECT * FROM Title WHERE id = :id LIMIT 1")
    suspend fun getTitle(id: Int): TitleEntity

    @Query("SELECT * FROM Title")
    suspend fun getTitles(): List<TitleEntity>

    @Query("SELECT COUNT(*) FROM Title")
    suspend fun getTitlesCount(): Int

}
