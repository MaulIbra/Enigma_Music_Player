package com.example.enigma_music_player.views.song.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.enigma_music_player.R
import com.example.enigma_music_player.data.room.song.Song

/**
 * Created by Maulana Ibrahim on 21/August/2020
 * Email maulibrahim19@gmail.com
 */
class SongRecycleAdapter(private val songList: List<Song>):RecyclerView.Adapter<SongViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.song_item,parent,false)
        return SongViewHolder(view)
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.tvSongTitle.text = songList[position].songTitle
        holder.tvSongDuration.text = songList[position].songDuration
    }
}