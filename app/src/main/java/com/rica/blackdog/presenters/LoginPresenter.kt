package com.rica.blackdog.presenters

import android.content.Context
import com.parse.ParseUser
import com.rica.blackdog.interfaces.GenericInterface
import com.rica.blackdog.interfaces.LoginInterface


class LoginPresenter (
        private val context: Context,
        private val mGeneric: GenericInterface,
        private val mInterface:LoginInterface
        ) {

    /**
     * @description This function is to validate login form
     * @param email
     * @param password
     */
    fun validate(email:String, password:String){
        if (email.isBlank()){
            this.mGeneric.onError("Ingres el correo electrónico")
        }
        if(password.isBlank()){
            this.mGeneric.onError("Ingres el correo electrónico")
        }
        login(email,password)
    }

    /**
     * @description This function is to login the user
     * @param email
     * @param password
     */
    private fun login(email: String, password: String){
        this.mGeneric.onLoading()
        ParseUser.logInInBackground(email, password) { user, e ->
            this.mGeneric.onLoadingDone()
            if (user != null) {
                mInterface.onSuccess()
            } else {
                mGeneric.onError("Correo o contraseña incorrectos")
            }
        }
    }

}