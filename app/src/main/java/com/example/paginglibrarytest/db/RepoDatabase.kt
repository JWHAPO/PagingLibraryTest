package com.example.paginglibrarytest.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.paginglibrarytest.model.*

/**
 * PagingLibraryTest
 * Class: RepoDatabase
 * Created by JEONGWOOKIM on 2020-03-05.
 * Description:
 */

@Database(
    entities = [Item::class, Repository::class, Owner::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(RepositoryPersistentConverter::class, OwnerPersistentConverter::class)
abstract class RepoDatabase : RoomDatabase() {

    abstract fun reposDao(): RepoDao

    companion object {

        @Volatile
        private var INSTANCE: RepoDatabase? = null

        fun getInstance(context: Context): RepoDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                RepoDatabase::class.java, "GithubPagingTest.db"
            )
                .build()
    }
}