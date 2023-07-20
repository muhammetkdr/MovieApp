package com.muhammetkudur.common

import androidx.annotation.StringRes

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

sealed class UiState<out T: Any> {
    object Loading : UiState<Nothing>()
    data class Success<T: Any>(val data: T) : UiState<T>()
    data class Error(@StringRes val message: Int) : UiState<Nothing>()
}