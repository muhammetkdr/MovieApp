package com.muhammetkudur.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.muhammetkudur.home.adapter.HomeTopRatedRVAdapter
import com.muhammetkudur.home.databinding.FragmentHomeBinding
import com.muhammetkudur.ui.common.collectFlow
import com.muhammetkudur.ui.utils.extensions.inflate
import com.muhammetkudur.ui.utils.pagingloadstateadapter.PagingLoadStateAdapter
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
        adapterItemClick()
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

    private fun adapterItemClick() {
        adapter.setOnItemClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(it.id)
            findNavController().navigate(action)
        }
    }
}