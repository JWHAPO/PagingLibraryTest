package com.example.paginglibrarytest.ex

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * WeatherApp
 * Class: RxExtension
 * Created by JEONGWOOKIM on 2020-01-23.
 * Description: Rx Extension
 */
fun <T> Observable<T>.with(): Observable<T> = subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())