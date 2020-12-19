package com.rica.blackdog.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.parse.ParseUser
import com.rica.blackdog.R
import com.rica.blackdog.utils.AbstractClass
import com.rica.blackdog.utils.Utils

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
        if (this.isLogedIn()){
            Utils.goTo(this, HomeActivity::class.java)
            finish()
        }else{
            Utils.goTo(this, LoginActivity::class.java)
            finish()
        }
    }

    private fun isLogedIn(): Boolean {
         if (ParseUser.getCurrentUser() != null) return true else return false
    }

}