package com.example.enigma_music_player.views.album.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.enigma_music_player.R
/**
 * Created by Maulana Ibrahim on 17/August/2020
 * Email maulibrahim19@gmail.com
 */

class AlbumViewHolder(v:View):RecyclerView.ViewHolder(v){
    val albumImageUrl:ImageView = v.findViewById(R.id.imgAlbum)
    val tvAlbumTitle:TextView = v.findViewById(R.id.tvAlbumTitle)
    val tvArtist:TextView = v.findViewById(R.id.tvArtist)
}