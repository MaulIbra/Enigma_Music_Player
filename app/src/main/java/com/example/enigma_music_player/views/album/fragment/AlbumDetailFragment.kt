package com.example.enigma_music_player.views.album.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

import com.example.enigma_music_player.R
import com.example.enigma_music_player.viewmodel.AlbumViewModel
import com.example.enigma_music_player.views.song.adapter.SongRecycleAdapter
import kotlinx.android.synthetic.main.fragment_album_detail.*

class AlbumDetailFragment : Fragment(), View.OnClickListener {

    private val albumViewModel by activityViewModels<AlbumViewModel>()
    lateinit var navController: NavController
    lateinit var songRecycleAdapter: SongRecycleAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        rvSongList.layoutManager = LinearLayoutManager(context)
        albumViewModel.songsByAlbum.observe(viewLifecycleOwner, Observer {
            songRecycleAdapter = SongRecycleAdapter(it)
            rvSongList.adapter = songRecycleAdapter
        })
        navController = Navigation.findNavController(view)
        btnAddSong.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view) {
            btnAddSong -> navController.navigate(R.id.action_albumDetailFragment_to_songInputFragment)
        }
    }
}
