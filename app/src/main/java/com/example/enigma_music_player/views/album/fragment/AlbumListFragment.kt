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

import com.example.enigma_music_player.R
import com.example.enigma_music_player.viewmodel.AlbumViewModel
import com.example.enigma_music_player.views.album.adapter.IAlbumRecycleListener
import com.example.enigma_music_player.views.album.adapter.AlbumRecycleAdapter
import kotlinx.android.synthetic.main.fragment_album_list.*

class AlbumListFragment : Fragment(),View.OnClickListener,IAlbumRecycleListener {

    val albumViewModel by activityViewModels<AlbumViewModel>()
    lateinit var albumRecycleAdapter: AlbumRecycleAdapter
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_album_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAddAlbum.setOnClickListener(this)
        navController = Navigation.findNavController(view)
        rvAlbumList.layoutManager = LinearLayoutManager(context)
        albumViewModel.allAlbum.observe(viewLifecycleOwner, Observer {
            albumRecycleAdapter = AlbumRecycleAdapter(it)
            albumRecycleAdapter.listener = this
            rvAlbumList.adapter = albumRecycleAdapter
        })
    }

    override fun onClick(v: View?) {
        when (v){
            btnAddAlbum -> navController.navigate(R.id.action_albumListFragment_to_albumInputFragment)
        }
    }

    override fun onItemClick(albumId: Int) {
        albumViewModel.detailAlbum(albumId)
        navController.navigate(R.id.action_albumListFragment_to_albumDetailFragment)
    }
}
