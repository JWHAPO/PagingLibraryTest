package com.example.paginglibrarytest.api

import android.util.Log
import com.example.paginglibrarytest.ex.with
import com.example.paginglibrarytest.model.Item
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * PagingLibraryTest
 * Class: GithubService
 * Created by JEONGWOOKIM on 2020-03-05.
 * Description:
 */

private const val TAG = "GithubPagingTest"
private const val BASE_QUERY = "addClass+user%3Amozilla"

fun searchItems(
    service: GithubService,
    query: String,
    page: Int,
    itemsPerPage: Int,
    onSuccess: (items: List<Item>) -> Unit,
    onError: (error: String) -> Unit
){
    Log.d(TAG, "query: $query, page: $page, itemsPerPage: $itemsPerPage")

    CompositeDisposable().add(
        service.searchItem(BASE_QUERY, page, itemsPerPage).with()
            .subscribe({
                val items = it.items
                onSuccess(items)
            },{
                onError("ERROR")
            })
    )
}

interface GithubService {
    @GET("search/code?sort=url&order=desc")
    fun searchItem(
        @Query("q", encoded = true) query: String,
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int
    ): Observable<GithubData>


    companion object {
        private const val BASE_URL = "https://api.github.com/"

        fun create(): GithubService {
            val logger = HttpLoggingInterceptor()
            logger.level = Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(GithubService::class.java)
        }
    }

}