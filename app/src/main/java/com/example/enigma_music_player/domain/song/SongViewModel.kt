package com.example.enigma_music_player.domain.song

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.enigma_music_player.domain.song.model.Song

/**
 * Created by Maulana Ibrahim on 17/August/2020
 * Email maulibrahim19@gmail.com
 */

class SongViewModel :ViewModel(){

    private val songList:MutableList<Song> = mutableListOf(
        Song("Bara Suara","Send Melagu","https://disk.mediaindonesia.com/thumbs/1800x1200/news/2019/02/2d9b0604173a61b10b2898706d275690.jpg"),
        Song("Danilla","Berdistraksi","https://pophariini.com/wp-content/uploads/2019/10/danillafingers-1.jpg"),
        Song(".Feast","Paid Milik Rakyat","https://cdn02.indozone.id/re/content/2020/04/26/n0sAe6/t_5ea516a66716f.jpg?w=700&q=85"),
        Song("Fourtwnty","Nematomorpha","https://static.republika.co.id/uploads/images/inpicture_slide/fourtwnty-_180905222330-614.jpg")
    )

    val songLiveData: MutableLiveData<MutableList<Song>> = MutableLiveData(songList)

    fun addLanguage(lang: String) {
    }
}