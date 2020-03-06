package com.example.paginglibrarytest.db

import androidx.paging.DataSource
import com.example.paginglibrarytest.model.Item
import java.util.concurrent.Executor

/**
 * PagingLibraryTest
 * Class: GithubLocalCache
 * Created by JEONGWOOKIM on 2020-03-05.
 * Description:
 */
class GithubLocalCache(
    private val repoDao: RepoDao,
    private val ioExecutor: Executor
) {
    fun insert(items: List<Item>, insertFinished: () -> Unit) {
        ioExecutor.execute {
            repoDao.insert(items)
            insertFinished()
        }
    }

    fun findAll(): DataSource.Factory<Int, Item> {
        return repoDao.findAll()
    }
}