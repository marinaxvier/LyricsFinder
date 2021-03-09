package com.example.lyricsfinder.network

import com.example.lyricsfinder.model.ReturnedLyrics
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LyricsService {
    @GET("{artist}/{title}")
    fun findLyrics (@Path("artist") artist: String, @Path("title") title: String): Call<ReturnedLyrics>
}