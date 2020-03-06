package com.example.paginglibrarytest.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.paginglibrarytest.api.GithubService
import com.example.paginglibrarytest.api.searchItems
import com.example.paginglibrarytest.db.GithubLocalCache
import com.example.paginglibrarytest.model.ItemSearchResult

/**
 * PagingLibraryTest
 * Class: GithubRepository
 * Created by JEONGWOOKIM on 2020-03-05.
 * Description:
 */
class GithubRepository (
    private val service: GithubService,
    private val cache: GithubLocalCache
){

    fun search(query: String): ItemSearchResult {

        val dataSourceFactory = cache.findAll()

        val boundaryCallback = ItemBoundaryCallback(query, service, cache)
        val networkErrors = boundaryCallback.networkErrors

//        val config = PagedList.Config.Builder()
//            .setInitialLoadSizeHint(20)
//            .setPageSize(10)
//            .setPrefetchDistance(5)
//            .setEnablePlaceholders(true)
//            .build()

        val data = LivePagedListBuilder(dataSourceFactory, DATABASE_PAGE_SIZE)
            .setBoundaryCallback(boundaryCallback)
            .build()

        return ItemSearchResult(data, networkErrors)
    }

    companion object {
        private const val DATABASE_PAGE_SIZE = 20
    }


}