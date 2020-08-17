package com.example.enigma_music_player.domain.song.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.enigma_music_player.R
import com.example.enigma_music_player.domain.song.SongViewModel
import com.example.enigma_music_player.domain.song.adapter.SongRecycleAdapter
import kotlinx.android.synthetic.main.fragment_song_list.*

class SongListFragment : Fragment() {

    val songViewModel by activityViewModels<SongViewModel>()
    lateinit var songRecycleAdapter: SongRecycleAdapter

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
        rvSongList.layoutManager = LinearLayoutManager(context)
        songRecycleAdapter = SongRecycleAdapter(songViewModel.songLiveData.value!!)
//        songRecycleAdapter.listener = view.context
        rvSongList.adapter = songRecycleAdapter
        songViewModel.songLiveData.observe(viewLifecycleOwner, Observer {
            songRecycleAdapter.notifyDataSetChanged()
        })
    }
}
