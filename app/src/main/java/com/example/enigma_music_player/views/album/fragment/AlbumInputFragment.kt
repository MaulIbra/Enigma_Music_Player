package com.example.enigma_music_player.views.album.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.enigma_music_player.R
import com.example.enigma_music_player.viewmodel.AlbumViewModel
import com.example.enigma_music_player.data.room.album.Album
import kotlinx.android.synthetic.main.fragment_album_input.*

class AlbumInputFragment : Fragment(),View.OnClickListener {

    private val albumViewModel by activityViewModels<AlbumViewModel>()
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_album_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSaveSong.setOnClickListener(this)
        navController = Navigation.findNavController(view)
    }

    override fun onClick(view: View?) {
        when(view){
            btnSaveSong -> {
                val artist = etName.text.toString()
                val albumTitle = etTitle.text.toString()
                val albumImageUrl = etImage.text.toString()
                albumViewModel.createAlbum(
                    Album(
                        artist = artist,
                        albumTitle = albumTitle,
                        albumImageUrl = albumImageUrl
                    )
                )
                navController.navigate(R.id.action_albumInputFragment_to_albumListFragment)
            }
        }
    }
}
