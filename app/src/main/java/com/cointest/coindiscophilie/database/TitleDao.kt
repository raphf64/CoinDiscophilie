package com.cointest.coindiscophilie.database

import androidx.room.*
import com.cointest.coindiscophilie.models.TitleEntity


@Dao
internal interface TitleDao{

    @Query("DELETE FROM Title")
    suspend fun deleteAll()

    @Query("SELECT * FROM Title WHERE id = :id LIMIT 1")
    suspend fun getTitle(id: Int): TitleEntity

    @Query("SELECT * FROM Title")
    suspend fun getTitles(): List<TitleEntity>

    @Query("SELECT COUNT(*) FROM Title")
    suspend fun getTitlesCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(obj: List<TitleEntity>): Array<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(obj: TitleEntity): Long
}
