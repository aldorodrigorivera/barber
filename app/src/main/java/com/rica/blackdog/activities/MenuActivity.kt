package com.rica.blackdog.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rica.blackdog.R
import com.rica.blackdog.utils.AbstractClass
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AbstractClass() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        init()
        buttons()
        queries()
    }

    override fun buttons() {
        super.buttons()
        btnClose.setOnClickListener {
            finish()
        }
    }
}