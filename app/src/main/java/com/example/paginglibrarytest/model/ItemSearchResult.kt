package com.example.paginglibrarytest.model

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

/**
 * PagingLibraryTest
 * Class: ItemSearchResult
 * Created by JEONGWOOKIM on 2020-03-05.
 * Description:
 */
data class ItemSearchResult(
    val data: LiveData<PagedList<Item>>,
    val networkErrors: LiveData<String>
)