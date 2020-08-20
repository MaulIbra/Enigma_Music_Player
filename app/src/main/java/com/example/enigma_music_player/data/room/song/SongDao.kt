package com.example.enigma_music_player.data.room.song

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query

/**
 * Created by Maulana Ibrahim on 20/August/2020
 * Email maulibrahim19@gmail.com
 */

interface SongDao {

    @Insert
    fun createSong(song: Song)

    @Query(value = "SELECT * FROM Song WHERE albumId=:albumId")
    fun getAllSong(albumId:Int):LiveData<List<Song>>

}