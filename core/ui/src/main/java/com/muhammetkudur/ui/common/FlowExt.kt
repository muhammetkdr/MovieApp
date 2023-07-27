package com.muhammetkudur.ui.common

import androidx.fragment.app.Fragment
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

fun <T> Fragment.collectFlow(
    flow: Flow<T>,
    action: suspend (T) -> Unit
) {
    viewLifecycleOwner.lifecycleScope.launch {
        flow.flowWithLifecycle(lifecycle).collect{
            action(it)
        }
    }
}