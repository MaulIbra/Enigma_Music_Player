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

    private var isPlayPosition = -1
    private var isPlay = false

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

        if (isPlayPosition == position){
            holder.imgPlayPause.setImageResource(R.drawable.ic_pause_black_24dp)
        }else{
            holder.imgPlayPause.setImageResource(R.drawable.ic_play_arrow_black_24dp)
        }

        holder.imgPlayPause.setOnClickListener{
            if (isPlayPosition == position && isPlay){
                isPlay = false
                holder.imgPlayPause.setImageResource(R.drawable.ic_play_arrow_black_24dp)
            }else if (isPlayPosition == position && !isPlay){
                isPlay = true
                holder.imgPlayPause.setImageResource(R.drawable.ic_pause_black_24dp)
            }else{
                isPlay = true
                isPlayPosition = position
                notifyDataSetChanged()
            }
        }
    }

}