package com.rica.blackdog.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.IntentSender
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.rica.blackdog.activities.LoginActivity

object Utils {

    fun isEmail(value:String): Boolean {
        return false
    }

    fun goTo(context: Context,to: Class<*>) {
        val intent = Intent(context, to)
        context.startActivity(intent)
    }

    fun toast(context: Context,msn:String){
        Toast.makeText(context, msn, Toast.LENGTH_SHORT).show()
    }

}
