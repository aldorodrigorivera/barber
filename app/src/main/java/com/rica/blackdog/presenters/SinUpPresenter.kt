package com.rica.blackdog.presenters

import android.content.Context
import com.parse.ParseUser
import com.rica.blackdog.interfaces.GenericInterface
import com.rica.blackdog.interfaces.LoginInterface
import com.rica.blackdog.interfaces.SingUpInterface


class SinUpPresenter (
        private val context: Context,
        private val mGeneric: GenericInterface,
        private val mInterface: SingUpInterface
        ) {

    /**
     * @description This function is to validate login form
     * @param email
     * @param password
     */
    fun validate(name:String, email:String, password:String, confirm: String, phone: String){
        if (name.isBlank()){
            this.mGeneric.onError("Ingresa el nombre")
            return
        }
        if (phone.isBlank()){
            this.mGeneric.onError("Ingresa tu celular")
            return
        }
        if (email.isBlank()){
            this.mGeneric.onError("Ingresa el correo electrónico")
            return
        }
        if(password.isBlank()){
            this.mGeneric.onError("Ingresa la contraseña")
            return
        }
        if(confirm.isBlank()){
            this.mGeneric.onError("Confirma la contraseña")
            return
        }
        if(password != confirm){
            this.mGeneric.onError("Las contraseñas no son iguales")
            return
        }

        singUp(name, email,password,phone)
    }

    /**
     * @description This function is to singUp the user
     * @param email
     * @param password
     * @param phone
     */
    private fun singUp(name:String, email: String, password: String, phone:String){
        this.mGeneric.onLoading()
        val user = ParseUser()
        user.username = email
        user.setPassword(password)
        user.email = email
        user.put("phone",phone)
        user.put("name",name)
        user.signUpInBackground { e ->
            if (e == null) {
                this.mGeneric.onLoadingDone()
                this.mInterface.onSuccess()
            } else {
                this.mGeneric.onLoadingDone()
                this.mGeneric.onError("No se pudo crear la cuenta verifique su información")
            }
        }
    }

}