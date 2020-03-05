package com.example.paginglibrarytest.model

import androidx.lifecycle.LiveData

/**
 * PagingLibraryTest
 * Class: ItemSearchResult
 * Created by JEONGWOOKIM on 2020-03-05.
 * Description:
 */
data class ItemSearchResult(
    val data: LiveData<List<Item>>,
    val networkErrors: LiveData<String>
)