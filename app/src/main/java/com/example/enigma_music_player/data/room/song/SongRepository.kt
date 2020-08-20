package com.example.enigma_music_player.data.room.song

import androidx.lifecycle.LiveData

/**
 * Created by Maulana Ibrahim on 20/August/2020
 * Email maulibrahim19@gmail.com
 */
class SongRepository(val songDao: SongDao) {

    fun getAllSong(albumId:Int):LiveData<List<Song>>{
        return songDao.getAllSong(albumId)
    }
}