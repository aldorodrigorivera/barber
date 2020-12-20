package com.rica.blackdog.presenters

import android.content.Context
import com.parse.ParseUser
import com.rica.blackdog.interfaces.GenericInterface
import com.rica.blackdog.interfaces.ProfileInterface


class ProfilePresenter (
        private val context: Context,
        private val mGeneric: GenericInterface,
        private val mInterface: ProfileInterface
        ) {

    /**
     * @description This function is to get the user info
     */
    fun userInfo(){
        this.mGeneric.onLoading()
        val query = ParseUser.getQuery()
        query.whereEqualTo("objectId", ParseUser.getCurrentUser().objectId)
        query.getFirstInBackground { user, e ->
            this.mGeneric.onLoadingDone()
            if (e == null) {
                this.mInterface.onSuccess(user)
            } else {
                this.mGeneric.onError("No se pudo obtener la información del usuario")
            }
        }
    }

}