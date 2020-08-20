package com.example.enigma_music_player.views.album

import android.app.Application
import androidx.lifecycle.*
import com.example.enigma_music_player.data.room.AppRoomDatabase
import com.example.enigma_music_player.data.room.album.Album
import com.example.enigma_music_player.data.room.album.AlbumRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Maulana Ibrahim on 17/August/2020
 * Email maulibrahim19@gmail.com
 */

class AlbumViewModel(application: Application) : AndroidViewModel(application){

    private val repository:AlbumRepository
    val allAlbum: LiveData<List<Album>>
    var album :LiveData<Album>


    init {
        val artistDao = AppRoomDatabase.getDatabaseInstance(application).albumDao()
        repository = AlbumRepository(artistDao)
        allAlbum = repository.allAlbum
        album = repository.getAlbumById()
    }

    fun createAlbum(album: Album) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createAlbum(album)
        }
    }
    fun detailAlbum(albumId:Int){
        viewModelScope.launch(Dispatchers.IO) {
            album = repository.getAlbumById(albumId)
        }
    }
}