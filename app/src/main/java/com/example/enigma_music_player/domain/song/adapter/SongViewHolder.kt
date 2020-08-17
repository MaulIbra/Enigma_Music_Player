package com.example.enigma_music_player.domain.song.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.enigma_music_player.R
/**
 * Created by Maulana Ibrahim on 17/August/2020
 * Email maulibrahim19@gmail.com
 */

class SongViewHolder(v:View):RecyclerView.ViewHolder(v){
    val imgSong:ImageView = v.findViewById(R.id.imgSong)
    val tvAlbum:TextView = v.findViewById(R.id.tvAlbum)
    val tvArtist:TextView = v.findViewById(R.id.tvArtist)
}