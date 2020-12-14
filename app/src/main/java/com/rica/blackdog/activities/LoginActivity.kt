package com.rica.blackdog.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rica.blackdog.R
import com.rica.blackdog.interfaces.GenericInterface
import com.rica.blackdog.interfaces.LoginInterface
import com.rica.blackdog.presenters.LoginPresenter
import com.rica.blackdog.utils.AbstractClass
import com.rica.blackdog.utils.Utils
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AbstractClass(), GenericInterface,LoginInterface {

    var mPresenter: LoginPresenter?=null
    var isBlocked: Boolean = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        buttons()
    }


    override fun init(){
        mPresenter = LoginPresenter(this,this,this)
    }


    override fun buttons() {
        super.buttons()
        btnLogin.setOnClickListener {
            if (!isBlocked){
                mPresenter!!.validate(
                        txtEmail.text.toString(),
                        txtPassword.text.toString()
                )
            }
        }
        btnSingUp.setOnClickListener {
            if (!isBlocked){
                Utils.goTo(this,LoginActivity::class.java)
            }

        }
        btnForgetPassword.setOnClickListener {
            Utils.toast(this,"Reestablecer contraseña")
        }
    }

    override fun onError(msn: String) {
        Toast.makeText(this, msn, Toast.LENGTH_SHORT).show()
    }

    override fun onLoading() {
        isBlocked = true
        loader.visibility = View.VISIBLE
    }

    override fun onLoadingDone() {
        isBlocked = false
        loader.visibility = View.GONE
    }

    override fun onSuccess() {
        Utils.goTo(this,HomeActivity::class.java)
        finish()
    }
}