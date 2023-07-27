package com.muhammetkudur.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

abstract class BaseViewModel : ViewModel() {

    private val _indicator = MutableLiveData<Boolean>()
    val indicator : LiveData<Boolean> = _indicator

    protected fun showIndicator() = _indicator.postValue(true)
    protected fun hideIndicator() = _indicator.postValue(false)

}