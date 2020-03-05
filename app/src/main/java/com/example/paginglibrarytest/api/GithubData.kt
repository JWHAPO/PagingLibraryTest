package com.example.paginglibrarytest.api

import com.example.paginglibrarytest.model.Item
import com.google.gson.annotations.SerializedName

data class GithubData(
    @field:SerializedName("incomplete_results") val incomplete_results: Boolean,
    @field:SerializedName("items") val items: List<Item> = emptyList(),
    @field:SerializedName("total_count") val total_count: Int
)