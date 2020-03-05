package com.example.paginglibrarytest.repository

import androidx.lifecycle.MutableLiveData
import com.example.paginglibrarytest.api.GithubData
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
    private var lastRequestedPage = 1
    private val networkError = MutableLiveData<String>()
    private var isRequestInProgress = false

    fun search(query: String): ItemSearchResult {
        lastRequestedPage = 1
        requestAndSaveData(query)

        val data = cache.findAll()
        return ItemSearchResult(data, networkError)
    }

    fun requestMore(query: String){
        requestAndSaveData(query)
    }

    private fun requestAndSaveData(query: String){
        if(isRequestInProgress) return

        isRequestInProgress = true
        searchItems(service, query, lastRequestedPage, NETWORK_PAGE_SIZE, { items ->
            cache.insert(items){
                lastRequestedPage++
                isRequestInProgress = false
            }
        },{ error ->
            networkError.postValue(error)
            isRequestInProgress = false
        })
    }


    companion object {
        private const val NETWORK_PAGE_SIZE = 50
    }

}