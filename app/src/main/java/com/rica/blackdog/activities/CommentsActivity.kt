package com.rica.blackdog.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.rica.blackdog.R
import com.rica.blackdog.interfaces.CommentInterface
import com.rica.blackdog.interfaces.GenericInterface
import com.rica.blackdog.presenters.CommentPresenter
import com.rica.blackdog.utils.AbstractClass
import com.rica.blackdog.utils.Utils
import kotlinx.android.synthetic.main.activity_comments.*

class CommentsActivity : AbstractClass(), GenericInterface, CommentInterface {

    var mPresenter: CommentPresenter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)
        init()
        buttons()
    }

    override fun init() {
        super.init()
        this.mPresenter = CommentPresenter(this,this,this)
    }

    override fun buttons() {
        super.buttons()
        btnSend.setOnClickListener {
            this.mPresenter!!.validate(txtTitle.text.toString(), txtMessage.text.toString())
        }
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

    override fun onSuccess() {
        Utils.toast(this, "Mensaje enviado")
        finish()
    }

}