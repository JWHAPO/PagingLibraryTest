package com.example.paginglibrarytest.model

import androidx.room.Entity

@Entity
data class Item(
    val git_url: String,
    val html_url: String,
    val name: String,
    val path: String,
    val repository: Repository,
    val score: Double,
    val sha: String,
    val url: String
)