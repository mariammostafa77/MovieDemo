package com.example.movieapp.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitHelper {
    companion object {
        var base_url = "https://howtodoandroid.com/"
        fun getRetrofit(): Retrofit? {
            return Retrofit.Builder().baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build()
        }
    }
}