package com.rica.blackdog.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.rica.blackdog.R

class MainActivity : AppCompatActivity() {

    val TIEMPO = 3000                           /*SPLASH*/
    private val mHandler = Handler()
    var run: Runnable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // OCULTA TOOLBAR POR DEFAULT
        supportActionBar!!.hide()
        // OCULTA LA BARRA  DE ESTATUS
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        // This function will change view
        mHandler.postDelayed({loadSplash()},TIEMPO.toLong())
    }

    fun loadSplash(){
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }
}