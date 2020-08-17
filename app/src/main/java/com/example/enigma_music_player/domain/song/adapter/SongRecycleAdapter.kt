package com.example.enigma_music_player.domain.song.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.enigma_music_player.R
import com.example.enigma_music_player.domain.song.model.Song

/**
 * Created by Maulana Ibrahim on 17/August/2020
 * Email maulibrahim19@gmail.com
 */
class SongRecycleAdapter(private val songList: MutableList<Song>) :
    RecyclerView.Adapter<SongViewHolder>() {

    lateinit var listener: ISongRecycleListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.song_item, parent, false)
        return SongViewHolder(view)
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.tvArtist.text = songList[position].artist
        holder.tvAlbum.text = songList[position].album
        Glide.with(holder.itemView.context).load(songList[position].songImageUrl)
            .placeholder(R.drawable.ic_progres_bar).diskCacheStrategy(
                DiskCacheStrategy.NONE
            )
            .into(holder.imgSong)
        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }
}