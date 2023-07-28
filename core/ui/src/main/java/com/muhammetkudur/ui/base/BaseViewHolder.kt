package com.muhammetkudur.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

abstract class BaseViewHolder<T: Any>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun onBind(data: T)
}