package com.muhammetkudur.common

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

sealed class UiState<out T: Any> {
    data object Idle : UiState<Nothing>()
    data class Success<T: Any>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
}