package com.example.enigma_music_player.views.song.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.enigma_music_player.R
/**
 * Created by Maulana Ibrahim on 21/August/2020
 * Email maulibrahim19@gmail.com
 */
class SongViewHolder(v:View):RecyclerView.ViewHolder(v) {
    val tvSongTitle = v.findViewById<TextView>(R.id.tvSongTitle)
    val imgPlayPause = v.findViewById<ImageView>(R.id.imgPlayPause)
    val tvSongDuration = v.findViewById<TextView>(R.id.tvSongDuration)
}