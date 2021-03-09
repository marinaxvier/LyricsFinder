package com.example.lyricsfinder.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {
    companion object{
        fun getRetrofitInstance(): Retrofit{
            return Retrofit.Builder()
                .baseUrl("https://api.lyrics.ovh/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}