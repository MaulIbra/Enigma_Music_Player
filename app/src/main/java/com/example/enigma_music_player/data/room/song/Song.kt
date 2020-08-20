package com.example.enigma_music_player.data.room.song

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Maulana Ibrahim on 20/August/2020
 * Email maulibrahim19@gmail.com
 */

@Entity
class Song(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "songId") var id:Int=0,
    @ColumnInfo(name = "albumId") var albumId:Int,
    @ColumnInfo(name = "songTitle") var songTitle:String,
    @ColumnInfo(name = "songDuration") var songDuration:String
)