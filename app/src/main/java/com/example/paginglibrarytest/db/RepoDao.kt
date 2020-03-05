package com.example.paginglibrarytest.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.paginglibrarytest.model.Item

/**
 * PagingLibraryTest
 * Class: RepoDao
 * Created by JEONGWOOKIM on 2020-03-05.
 * Description:
 */
@Dao
interface RepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts: List<Item>)

    @Query("SELECT * FROM item")
    fun findAll(): LiveData<List<Item>>
}