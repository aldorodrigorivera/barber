package com.rica.blackdog.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rica.blackdog.R
import com.rica.blackdog.utils.AbstractClass
import kotlinx.android.synthetic.main.activity_points_of_sale.*

class PointsOfSaleActivity : AbstractClass() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_points_of_sale)
        init()
    }

    override fun init() {
        super.init()
        println("Print")
    }

    override fun buttons() {
        super.buttons()
        lbTitle.setOnClickListener {
            finish()
        }

    }
}