package com.example.enigma_music_player.views.song.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.enigma_music_player.R
import com.example.enigma_music_player.common.convertTimeString
import com.example.enigma_music_player.data.room.song.Song
import com.example.enigma_music_player.viewmodel.AlbumViewModel
import kotlinx.android.synthetic.main.fragment_song_input.*

class SongInputFragment : Fragment(),View.OnClickListener {

    private val albumViewModel by activityViewModels<AlbumViewModel>()
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_song_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSaveSong.setOnClickListener(this)
        navController = Navigation.findNavController(view)
    }

    override fun onClick(view: View?) {
        when(view){
            btnSaveSong -> {
                val songTitle = etSongTitle.text.toString()
                val songDurationTemp = etSongDuration.text.toString()
                val songDuration = convertTimeString(songDurationTemp)
                albumViewModel.createSong(
                    Song(songTitle = songTitle,songDuration = songDuration,albumId = albumViewModel.album.value?.id!!)
                )
              navController.navigate(R.id.action_songInputFragment_to_albumDetailFragment)
            }
        }
    }

}
