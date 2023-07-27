package com.muhammetkudur.ui.common

import android.view.View
import com.google.android.material.snackbar.Snackbar

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

fun View.showSnackbar(msg: String) {
    try {
        Snackbar.make(this, msg, 10000).show()
    }catch (e:Exception){
        println(e.message)
    }
}