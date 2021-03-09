package com.example.lyricsfinder.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lyricsfinder.model.ReturnedLyrics
import com.example.lyricsfinder.network.LyricsService
import com.example.lyricsfinder.network.NetworkUtils
import retrofit2.Call
import retrofit2.Response

class LyricsViewModel : ViewModel() {

    val lyrics: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val error: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    fun getData(artist: String, song: String){
        var retrofitClient = NetworkUtils.getRetrofitInstance()
        var endpoint = retrofitClient.create(LyricsService::class.java)
        val callback = endpoint.findLyrics(artist, song)

        callback.enqueue(object : retrofit2.Callback<ReturnedLyrics> {
            override fun onResponse(call: Call<ReturnedLyrics>,
                                    response: Response<ReturnedLyrics>
            ) {
                var returnedLyrics: ReturnedLyrics? = response.body()
                lyrics.value = returnedLyrics?.toString()
            }

            override fun onFailure(call: Call<ReturnedLyrics>, t: Throwable) {
                error.value = "Erro ao realizar a busca"
            }

        })
    }
}