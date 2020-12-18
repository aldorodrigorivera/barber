package com.rica.blackdog.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.parse.ParseObject
import com.rica.blackdog.R
import com.rica.blackdog.adapters.ProductsAdapter
import com.rica.blackdog.adapters.ServiceAdapter
import com.rica.blackdog.interfaces.GenericInterface
import com.rica.blackdog.interfaces.ProductsInterface
import com.rica.blackdog.presenters.ProductsPresenter
import com.rica.blackdog.utils.AbstractClass
import com.rica.blackdog.utils.Utils
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_products.*
import kotlinx.android.synthetic.main.activity_products.list
import kotlinx.android.synthetic.main.activity_products.loader

class ProductsActivity : AbstractClass(),GenericInterface, ProductsInterface {

    var mPresenter: ProductsPresenter ?=null
    var productsObject : ArrayList<ParseObject> ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        init()
        buttons()
        queries()
    }

    override fun init() {
        super.init()
        this.productsObject = ArrayList()
        this.mPresenter = ProductsPresenter(this,this,this)
    }

    override fun buttons() {
        super.buttons()
        btnClose.setOnClickListener {
            finish()
        }
    }

    override fun queries() {
        super.queries()
        this.mPresenter!!.getAllProducts()
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

    override fun onSuccess(products: ArrayList<ParseObject>) {
        this.productsObject = products
        val mAdapter = ProductsAdapter(this,products,this)
        val mLayoutManager = GridLayoutManager(this,2)
        list!!.setLayoutManager(mLayoutManager)
        list!!.setItemAnimator(DefaultItemAnimator())
        list!!.setAdapter(mAdapter)
    }
}