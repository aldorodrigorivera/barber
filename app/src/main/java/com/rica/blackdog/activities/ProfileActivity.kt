package com.rica.blackdog.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.parse.ParseObject
import com.rica.blackdog.R
import com.rica.blackdog.interfaces.GenericInterface
import com.rica.blackdog.interfaces.ProfileInterface
import com.rica.blackdog.presenters.ProfilePresenter
import com.rica.blackdog.utils.AbstractClass
import com.rica.blackdog.utils.Utils
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AbstractClass(),GenericInterface, ProfileInterface {
    var mPresenter: ProfilePresenter?=null
    var user: ParseObject ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        init()
        buttons()
        queries()
    }

    override fun init() {
        super.init()
        this.mPresenter = ProfilePresenter(this,this,this)
    }

    override fun queries() {
        super.queries()
        this.mPresenter!!.userInfo()
    }

    override fun buttons() {
        super.buttons()
        btnClose.setOnClickListener {
            finish()
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

    override fun onSuccess(profile: ParseObject) {
        this.user = profile
        txtName.text = profile.getString("name")
        txtPhone.text = profile.getString("phone")
        txtEmail.text = profile.getString("email")
        txtPoints.text = profile.getNumber("points")?.toString()
    }
}