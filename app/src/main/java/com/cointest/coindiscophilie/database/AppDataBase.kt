package com.cointest.coindiscophilie.database

import android.content.Context
import androidx.room.Room
import androidx.room.Database
import androidx.room.RoomDatabase
import com.cointest.coindiscophilie.models.TitleEntity


@Database(
    entities = [TitleEntity::class],
    version = 1,
    exportSchema = false
)
internal abstract class AppDataBase : RoomDatabase() {

    companion object {
        private var instance : AppDataBase? = null

        fun getInstance(context: Context, dbName: String) : AppDataBase {
            if (instance == null) {
                instance = synchronized(AppDataBase::class) {
                    Room.databaseBuilder(context, AppDataBase::class.java, dbName)
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return instance!!
        }
    }

    //RoomDatabase Implementation

    abstract val titleDao: TitleDao

    //end

}
