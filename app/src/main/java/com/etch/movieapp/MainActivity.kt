package com.etch.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.etch.movieapp.adapter.TvShowAdapter
import com.etch.movieapp.databinding.ActivityMainBinding
import com.etch.movieapp.viewmodel.TvShowsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: TvShowsViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    private lateinit var tvShowsAdapter: TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        setUpRV()

    }

    private fun setUpRV() {
        tvShowsAdapter = TvShowAdapter()

        binding.recyclerView.apply {
            adapter = tvShowsAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
        binding.rvEpisodes.apply {
            adapter = tvShowsAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
        binding.rvRecentlyAdded.apply {
            adapter = tvShowsAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        viewModel.responseTvShow.observe(this, { listTvShows ->
            tvShowsAdapter.tvShows = listTvShows
        })


    }
}