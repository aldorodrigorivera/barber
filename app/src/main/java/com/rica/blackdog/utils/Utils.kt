package com.rica.blackdog.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.parse.ParseObject
import com.parse.ParseUser
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

    fun logOut(context: Context){
        ParseUser.logOut()
        this.goTo(context, LoginActivity::class.java)
    }

    fun callPhone(context: Context, phone: String) {
        val dialIntent = Intent(Intent.ACTION_DIAL)
        dialIntent.data = Uri.parse("tel:" + phone)
        context.startActivity(dialIntent)
    }

    fun goMaps(context: Context, point:ParseObject){
        val gmmIntentUri = Uri.parse(
            "geo:" +
                    "${point.getParseGeoPoint("location").latitude}," +
                    "${point.getParseGeoPoint("location").longitude}"
        )
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        context.startActivity(mapIntent)
    }

}
