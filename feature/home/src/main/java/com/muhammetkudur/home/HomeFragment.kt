package com.muhammetkudur.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.moviepagingxml.ui.home.adapter.HomeTopRatedRVAdapter
import com.muhammetkudur.home.databinding.FragmentHomeBinding
import com.muhammetkudur.ui.common.collectFlow
import com.muhammetkudur.ui.utils.PagingLoadStateAdapter
import com.muhammetkudur.ui.utils.inflate
import dagger.hilt.android.AndroidEntryPoint

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binder by inflate(FragmentHomeBinding::bind)
    private val viewModel by viewModels<HomeViewModel>()
    private val adapter by lazy { HomeTopRatedRVAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        observeData()
    }

    private fun observeData() {
        collectFlow(viewModel.getTopRatedMoviesData()){
            adapter.submitData(it)
        }
    }

    private fun initAdapter() {
        binder.homeRv.adapter = adapter.withLoadStateHeaderAndFooter(
            header = PagingLoadStateAdapter(adapter),
            footer = PagingLoadStateAdapter(adapter)
        )
    }
}