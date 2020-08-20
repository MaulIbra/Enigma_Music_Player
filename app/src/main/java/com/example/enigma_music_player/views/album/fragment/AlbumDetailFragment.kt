package com.example.enigma_music_player.views.album.fragment

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
import com.example.enigma_music_player.views.album.AlbumViewModel
import kotlinx.android.synthetic.main.fragment_album_detail.*

class AlbumDetailFragment : Fragment() {

    private val albumViewModel by activityViewModels<AlbumViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        albumViewModel.album.observe(viewLifecycleOwner, Observer {
            Glide.with(this).load(it.albumImageUrl).fitCenter()
                .placeholder(R.drawable.ic_progres_bar).diskCacheStrategy(
                    DiskCacheStrategy.NONE
                )
                .into(imgSongDetail)
            tvArtistDetail.text = it.artist
        })
    }
}
