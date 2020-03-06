package com.example.paginglibrarytest.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.paginglibrarytest.model.Item
import com.example.paginglibrarytest.model.ItemSearchResult
import com.example.paginglibrarytest.data.GithubRepository

/**
 * PagingLibraryTest
 * Class: MainViewModel
 * Created by JEONGWOOKIM on 2020-03-05.
 * Description:
 */
class MainViewModel(private val repository: GithubRepository) : ViewModel(){

    private val queryLiveData = MutableLiveData<String>()
    private val repoResult: LiveData<ItemSearchResult> = Transformations.map(queryLiveData) {
        repository.search(it)
    }

    val items: LiveData<PagedList<Item>> = Transformations.switchMap(repoResult) { it.data }
    val networkErrors: LiveData<String> = Transformations.switchMap(repoResult) { it.networkErrors }

    fun searchItem(query: String){
        queryLiveData.postValue(query)
    }

    fun lastQueryValue(): String? = queryLiveData.value

}