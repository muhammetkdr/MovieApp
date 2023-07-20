package com.muhammetkudur.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muhammetkudur.movieapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}