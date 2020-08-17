package com.example.enigma_music_player.domain.song.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

import com.example.enigma_music_player.R
import com.example.enigma_music_player.domain.song.SongViewModel
import kotlinx.android.synthetic.main.fragment_song_detail.*
import kotlinx.android.synthetic.main.song_item.*

class SongDetailFragment : Fragment() {

    private val songViewModel by activityViewModels<SongViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_song_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        songViewModel.songLiveData.observe(viewLifecycleOwner, Observer {
            Glide.with(this).load(it.songImageUrl).fitCenter()
                .placeholder(R.drawable.ic_progres_bar).diskCacheStrategy(
                    DiskCacheStrategy.NONE
                )
                .into(imgSongDetail)
            tvArtistDetail.text = it.artist
        })
    }
}
