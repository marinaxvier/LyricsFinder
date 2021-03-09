package com.example.lyricsfinder.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.lyricsfinder.R
import com.example.lyricsfinder.view.viewModel.LyricsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: LyricsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = LyricsViewModel()

        btnSearch.setOnClickListener {
            val artist: String = etArtist.text.toString()
            val song: String = etSong.text.toString()

            if (artist.isNullOrEmpty() || song.isNullOrEmpty()){
                Toast.makeText(this, "Você deve preencher todos os campos de pesquisa",Toast.LENGTH_SHORT).show()
            }else{
                viewModel.getData(artist, song)
            }

        }

        viewModel.lyrics.observe(this, Observer {
            Toast.makeText(this,"Retorno: $it",Toast.LENGTH_SHORT).show()
        })

    }


}