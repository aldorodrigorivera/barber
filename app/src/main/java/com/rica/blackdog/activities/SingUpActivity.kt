package com.rica.blackdog.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.rica.blackdog.R
import com.rica.blackdog.interfaces.GenericInterface
import com.rica.blackdog.interfaces.SingUpInterface
import com.rica.blackdog.presenters.SinUpPresenter
import com.rica.blackdog.utils.AbstractClass
import com.rica.blackdog.utils.Utils
import kotlinx.android.synthetic.main.activity_sing_up.*

class SingUpActivity : AbstractClass(), GenericInterface, SingUpInterface {

    var mPresenter: SinUpPresenter ?= null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)
        init()
        buttons()
    }

    override fun init() {
        super.init()
        this.mPresenter = SinUpPresenter(this,this,this)
    }

    override fun buttons() {
        super.buttons()
        btnClose.setOnClickListener {
            finish()
        }
        btnSingUp.setOnClickListener {
            this.mPresenter!!.validate(
                txtName.text.toString(),
                txtEmail.text.toString(),
                txtPassword.text.toString(),
                txtPasswordConfirm.text.toString(),
                txtPhone.text.toString()
            )
        }
    }

    override fun onError(msn: String) {
        Utils.toast(this, msn)
    }

    override fun onLoading() {
        loader.visibility = View.VISIBLE
    }

    override fun onLoadingDone() {
        loader.visibility = View.GONE
    }

    override fun onSuccess() {
        Utils.goTo(this, HomeActivity::class.java)
    }
}