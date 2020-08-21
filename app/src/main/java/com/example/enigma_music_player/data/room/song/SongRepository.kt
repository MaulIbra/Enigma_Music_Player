package com.example.enigma_music_player.data.room.song

import androidx.lifecycle.LiveData

/**
 * Created by Maulana Ibrahim on 20/August/2020
 * Email maulibrahim19@gmail.com
 */
class SongRepository(val songDao: SongDao) {

    fun createSong(song: Song){
        songDao.createSong(song)
    }

    fun getAllSong(albumId:Int=0):LiveData<List<Song>>{
        return songDao.getAllSong(albumId)
    }
}