package com.cointest.coindiscophilie.database

import androidx.room.*


internal interface DaoBase<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(obj: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(obj: List<T>): Array<Long>

}
