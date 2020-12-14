package com.rica.blackdog.interfaces

import android.view.View

interface GenericInterface {
    fun onError(msn: String)
    fun onLoading()
    fun onLoadingDone()
}