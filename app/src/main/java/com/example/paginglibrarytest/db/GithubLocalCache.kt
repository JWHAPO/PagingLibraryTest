package com.example.paginglibrarytest.db

import android.database.Observable
import androidx.lifecycle.LiveData
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
    fun insert(repos: List<Item>, insertFinished: () -> Unit) {
        ioExecutor.execute {
            repoDao.insert(repos)
            insertFinished()
        }
    }

    fun findAll(): LiveData<List<Item>> {
        return repoDao.findAll()
    }
}