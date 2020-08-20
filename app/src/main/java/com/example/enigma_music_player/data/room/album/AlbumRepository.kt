package com.example.enigma_music_player.data.room.album

import androidx.lifecycle.LiveData

/**
 * Created by Maulana Ibrahim on 20/August/2020
 * Email maulibrahim19@gmail.com
 */
class AlbumRepository(val albumDao: AlbumDao) {

    val allAlbum: LiveData<List<Album>> = albumDao.getAllAlbum()

    fun getAlbumById(id:Int=0):LiveData<Album>{
        return albumDao.getAlbumById(id)
    }

    fun createAlbum(album: Album){
        albumDao.createAlbum(album)
    }
}