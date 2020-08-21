package com.example.enigma_music_player.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.enigma_music_player.data.room.AppRoomDatabase
import com.example.enigma_music_player.data.room.album.Album
import com.example.enigma_music_player.data.room.album.AlbumRepository
import com.example.enigma_music_player.data.room.song.Song
import com.example.enigma_music_player.data.room.song.SongRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Maulana Ibrahim on 17/August/2020
 * Email maulibrahim19@gmail.com
 */

class AlbumViewModel(application: Application) : AndroidViewModel(application){

    private val albumRepository:AlbumRepository
    private val songRepository:SongRepository

    val allAlbum: LiveData<List<Album>>
    var album :LiveData<Album>
    private set
    var songsByAlbum : LiveData<List<Song>>
    private set


    init {
        val artistDao = AppRoomDatabase.getDatabaseInstance(application).albumDao()
        val songDao = AppRoomDatabase.getDatabaseInstance(application).songDao()
        albumRepository = AlbumRepository(artistDao)
        songRepository = SongRepository(songDao)
        allAlbum = albumRepository.allAlbum
        album = albumRepository.getAlbumById()
        songsByAlbum = songRepository.getAllSong()
    }

    fun createAlbum(album: Album) {
        viewModelScope.launch(Dispatchers.IO) {
            albumRepository.createAlbum(album)
        }
    }
    fun detailAlbum(albumId:Int){
        viewModelScope.launch(Dispatchers.IO) {
            album = albumRepository.getAlbumById(albumId)
            songsByAlbum = songRepository.getAllSong(albumId)
        }
    }

    fun createSong(song: Song){
        viewModelScope.launch(Dispatchers.IO) {
            songRepository.createSong(song)
        }
    }
}