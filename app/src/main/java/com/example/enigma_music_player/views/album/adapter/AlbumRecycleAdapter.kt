package com.example.enigma_music_player.views.album.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.enigma_music_player.R
import com.example.enigma_music_player.data.room.album.Album

/**
 * Created by Maulana Ibrahim on 17/August/2020
 * Email maulibrahim19@gmail.com
 */
class AlbumRecycleAdapter(private val albumList: List<Album>) :
    RecyclerView.Adapter<AlbumViewHolder>() {

    lateinit var listener: IAlbumRecycleListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.album_item, parent, false)
        return AlbumViewHolder(view)
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.tvArtist.text = albumList[position].artist
        holder.tvAlbumTitle.text = albumList[position].albumTitle
        Glide.with(holder.itemView.context).load(albumList[position].albumImageUrl)
            .placeholder(R.drawable.ic_progres_bar).diskCacheStrategy(
                DiskCacheStrategy.NONE
            )
            .into(holder.albumImageUrl)
        holder.itemView.setOnClickListener {
            listener.onItemClick(albumList[position].id)
        }
    }
}