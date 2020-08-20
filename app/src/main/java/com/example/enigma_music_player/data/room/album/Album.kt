package com.example.enigma_music_player.data.room.album

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Maulana Ibrahim on 17/August/2020
 * Email maulibrahim19@gmail.com
 */

@Entity
data class Album (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "albumId") var id:Int = 0,
    @ColumnInfo(name = "artist") var artist:String,
    @ColumnInfo(name = "albumTitle") var albumTitle:String,
    @ColumnInfo(name = "albumImageUrl") var albumImageUrl:String
)