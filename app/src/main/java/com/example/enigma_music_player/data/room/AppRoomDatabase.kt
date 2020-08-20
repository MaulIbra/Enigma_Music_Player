package com.example.enigma_music_player.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.enigma_music_player.data.room.album.Album
import com.example.enigma_music_player.data.room.album.AlbumDao
import com.example.enigma_music_player.data.room.song.Song
import com.example.enigma_music_player.data.room.song.SongDao

/**
 * Created by Maulana Ibrahim on 20/August/2020
 * Email maulibrahim19@gmail.com
 */

@Database(entities = arrayOf(Album::class,Song::class), version = 2, exportSchema = false)
abstract class AppRoomDatabase:RoomDatabase() {

    abstract fun albumDao():AlbumDao

    abstract fun songDao():SongDao


    companion object{
        private var DATABASE_INSTANCE:AppRoomDatabase? = null

        fun getDatabaseInstance(context: Context):AppRoomDatabase{
            if (DATABASE_INSTANCE != null) {
                return DATABASE_INSTANCE as AppRoomDatabase
            }
            DATABASE_INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppRoomDatabase::class.java,
                "spotify_database"
            ).fallbackToDestructiveMigration().build()
            return DATABASE_INSTANCE as AppRoomDatabase
        }
    }
}