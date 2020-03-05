package com.example.paginglibrarytest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.paginglibrarytest.databinding.MainLayoutBinding

/**
 * PagingLibraryTest
 * Class: MainActivity
 * Created by JEONGWOOKIM on 2020-03-05.
 * Description:
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainLayoutBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }
}