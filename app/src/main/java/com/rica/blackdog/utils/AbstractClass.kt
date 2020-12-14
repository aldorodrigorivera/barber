package com.rica.blackdog.utils

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

abstract class AbstractClass: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    open fun init(){
        println("Init")

    }

    open fun buttons(){
        println("Btns")
    }

    open fun queries(){
        println("Query")
    }
}