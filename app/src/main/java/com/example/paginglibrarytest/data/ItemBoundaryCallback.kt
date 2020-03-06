package com.example.paginglibrarytest.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.example.paginglibrarytest.api.GithubService
import com.example.paginglibrarytest.api.searchItems
import com.example.paginglibrarytest.db.GithubLocalCache
import com.example.paginglibrarytest.model.Item

/**
 * PagingLibraryTest
 * Class: ItemBoundaryCallback
 * Created by JEONGWOOKIM on 2020-03-06.
 * Description:
 */
class ItemBoundaryCallback(
    private val  query: String,
    private val  service: GithubService,
    private val  cache: GithubLocalCache
) : PagedList.BoundaryCallback<Item>() {

    private var lastRequestedPage = 1
    private val _networkErrors = MutableLiveData<String>()
    val networkErrors: LiveData<String>
        get() = _networkErrors
    private var isRequestInProgress = false

    override fun onZeroItemsLoaded() {
        requestAndSaveData(query)
    }

    override fun onItemAtEndLoaded(itemAtEnd: Item) {
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
            _networkErrors.postValue(error)
            isRequestInProgress = false
        })
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 40
    }

}