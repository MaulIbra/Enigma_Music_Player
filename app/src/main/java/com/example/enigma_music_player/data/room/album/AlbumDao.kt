package com.example.enigma_music_player.data.room.album

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * Created by Maulana Ibrahim on 20/August/2020
 * Email maulibrahim19@gmail.com
 */

@Dao
interface AlbumDao {

    @Insert
    fun createAlbum(album: Album)

    @Query(value = "SELECT * FROM Album")
    fun getAllAlbum(): LiveData<List<Album>>

    @Query(value = "SELECT * FROM Album WHERE albumId=:id")
    fun getAlbumById(id:Int): LiveData<Album>

}