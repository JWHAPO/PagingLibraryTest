package com.example.paginglibrarytest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.paginglibrarytest.repository.GithubRepository

/**
 * PagingLibraryTest
 * Class: ViewModelFactory
 * Created by JEONGWOOKIM on 2020-03-05.
 * Description:
 */
class ViewModelFactory(private val repository: GithubRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}