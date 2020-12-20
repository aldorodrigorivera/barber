package com.rica.blackdog.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.parse.ParseObject
import com.rica.blackdog.R
import com.rica.blackdog.adapters.PointsAdapter
import com.rica.blackdog.adapters.ProductsAdapter
import com.rica.blackdog.interfaces.GenericInterface
import com.rica.blackdog.interfaces.PointsOfSaleInterface
import com.rica.blackdog.presenters.PointsOfSalePresenter
import com.rica.blackdog.utils.AbstractClass
import com.rica.blackdog.utils.Utils
import kotlinx.android.synthetic.main.activity_points_of_sale.*
import kotlinx.android.synthetic.main.activity_points_of_sale.btnClose
import kotlinx.android.synthetic.main.activity_points_of_sale.list
import kotlinx.android.synthetic.main.activity_points_of_sale.loader
import kotlinx.android.synthetic.main.activity_products.*
import java.util.ArrayList

class PointsOfSaleActivity : AbstractClass(),GenericInterface, PointsOfSaleInterface {

    var mPresenter: PointsOfSalePresenter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_points_of_sale)
        init()
        buttons()
        queries()
    }

    override fun init() {
        super.init()
        this.mPresenter = PointsOfSalePresenter(this,this,this)
    }

    override fun buttons() {
        super.buttons()
        btnClose.setOnClickListener {
            finish()
        }
    }

    override fun queries() {
        super.queries()
        this.mPresenter!!.getPointsOfSale()
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

    override fun onSuccess(points: ArrayList<ParseObject>) {
        val mAdapter = PointsAdapter(this,points,this)
        val mLayoutManager = GridLayoutManager(this,1)
        list!!.setLayoutManager(mLayoutManager)
        list!!.setItemAnimator(DefaultItemAnimator())
        list!!.setAdapter(mAdapter)
    }

    override fun onClick(pointOfSale: ParseObject) {
        Utils.goMaps(this,pointOfSale)
    }
}