package com.example.enigma_music_player.domain.song.fragment

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
import com.example.enigma_music_player.domain.song.SongViewModel
import com.example.enigma_music_player.domain.song.adapter.SongRecycleAdapter
import kotlinx.android.synthetic.main.fragment_song_list.*

class SongListFragment : Fragment(),View.OnClickListener {

    val songViewModel by activityViewModels<SongViewModel>()
    lateinit var songRecycleAdapter: SongRecycleAdapter
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_song_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAddSong.setOnClickListener(this)
        navController = Navigation.findNavController(view)
        rvSongList.layoutManager = LinearLayoutManager(context)
        songRecycleAdapter = SongRecycleAdapter(songViewModel.songLiveData.value!!)
//        songRecycleAdapter.listener = view.context
        rvSongList.adapter = songRecycleAdapter
        songViewModel.songLiveData.observe(viewLifecycleOwner, Observer {
            songRecycleAdapter.notifyDataSetChanged()
        })
    }

    override fun onClick(v: View?) {
        when (v){
            btnAddSong -> navController.navigate(R.id.action_songListFragment_to_songInputFragment)
        }
    }
}
