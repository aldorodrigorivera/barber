package com.rica.blackdog.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.rica.blackdog.R
import com.rica.blackdog.utils.AbstractClass

class MainActivity : AbstractClass() {

    val TIEMPO = 3000
    private val mHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        mHandler.postDelayed({loadSplash()},TIEMPO.toLong())
    }

    fun loadSplash(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}