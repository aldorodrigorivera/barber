package com.rica.blackdog.presenters

import android.content.Context
import com.parse.ParseObject
import com.parse.ParseUser
import com.rica.blackdog.interfaces.CommentInterface
import com.rica.blackdog.interfaces.GenericInterface
import com.rica.blackdog.interfaces.SingUpInterface


class CommentPresenter (
        private val context: Context,
        private val mGeneric: GenericInterface,
        private val mInterface: CommentInterface
        ) {

    /**
     * @description This function is to validate login form
     * @param email
     * @param password
     */
    fun validate(title:String, msn:String ){
        if (title.isBlank()){
            this.mGeneric.onError("Ingresa el título")
            return
        }
        if (msn.isBlank()){
            this.mGeneric.onError("Ingresa el mensaje")
            return
        }

        register(title, msn)
    }

    /**
     * @description This function is to singUp the user
     * @param email
     * @param password
     * @param phone
     */
    private fun register(title:String, msn: String){
        this.mGeneric.onLoading()
        val user = ParseUser.getCurrentUser()
        val comment = ParseObject("Comment")
        comment.put("user", user)
        comment.put("title",title)
        comment.put("message", msn)
        comment.saveInBackground()
        comment.saveInBackground { e ->
            this.mGeneric.onLoadingDone()
            if (e == null) {
                this.mInterface.onSuccess()
            } else {
                println("Error: ${e.message}")
                this.mGeneric.onError("No se pudo guardar el mensaje")
            }
        }
    }

}