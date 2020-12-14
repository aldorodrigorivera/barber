package com.rica.blackdog.activities

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.parse.ParseObject
import com.rica.blackdog.R
import com.rica.blackdog.adapters.ServiceAdapter
import com.rica.blackdog.interfaces.GenericInterface
import com.rica.blackdog.interfaces.HomeInterface
import com.rica.blackdog.presenters.HomePresenter
import com.rica.blackdog.utils.AbstractClass
import com.rica.blackdog.utils.Utils
import kotlinx.android.synthetic.main.activity_home.*
import java.util.ArrayList

class HomeActivity : AbstractClass(), GenericInterface, HomeInterface {

    var mPresenter: HomePresenter?=null
    var servicesObjects: ArrayList<ParseObject> ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        init()
        buttons()
        queries()
    }

    override fun init() {
        super.init()
        this.servicesObjects = ArrayList()
        this.mPresenter = HomePresenter(this,this,this)
    }

    override fun buttons() {
        super.buttons()
        btnMenu.setOnClickListener {
            Utils.toast(this, "Menu")
        }
        btnPointOfSale.setOnClickListener {
            Utils.goTo(this,PointsOfSaleActivity::class.java)
        }
    }

    override fun queries() {
        super.queries()
        this.mPresenter!!.getAllServices()
    }

    override fun onError(msn: String) {
        Utils.toast(this,msn)
    }

    override fun onLoading() {
        loader.visibility = View.VISIBLE
    }

    override fun onLoadingDone() {
        loader.visibility = View.GONE
    }

    override fun onSuccess(services: ArrayList<ParseObject>) {
        this.servicesObjects = services
        val mAdapter = ServiceAdapter(this,services,this)
        val mLayoutManager = GridLayoutManager(this,1)
        list!!.setLayoutManager(mLayoutManager)
        list!!.setItemAnimator(DefaultItemAnimator())
        list!!.setAdapter(mAdapter)
    }

    override fun onClick(service: ParseObject) {
        Utils.toast(this, service.getString("name"))
    }
}