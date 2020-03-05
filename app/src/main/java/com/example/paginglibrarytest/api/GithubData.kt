package com.example.paginglibrarytest.api

import com.example.paginglibrarytest.model.Item

data class GithubData(
    val incomplete_results: Boolean,
    val items: List<Item> = emptyList(),
    val total_count: Int
)