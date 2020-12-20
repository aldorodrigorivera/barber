package com.rica.blackdog.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rica.blackdog.R
import com.rica.blackdog.utils.AbstractClass
import com.rica.blackdog.utils.Utils
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AbstractClass() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        buttons()
    }

    override fun buttons() {
        super.buttons()
        btnClose.setOnClickListener {
            finish()
        }
        btnLogOut.setOnClickListener {
            Utils.logOut(this)
        }
        btnProfile.setOnClickListener {
            Utils.goTo(this,ProfileActivity::class.java)
        }
        btnPointOfSale.setOnClickListener {
            Utils.toast(this,"Sucursales")
        }
        btnPaymentMethods.setOnClickListener {
            Utils.toast(this,"Métodos de pago")
        }
        btnComments.setOnClickListener {
            Utils.toast(this,"Comentarios")
        }

        btnCustomerService.setOnClickListener {
            Utils.callPhone(this, "4421110000")
        }
        btnReservations.setOnClickListener {
            Utils.toast(this,"Citas")
        }
        btnHistory.setOnClickListener {
            Utils.toast(this,"Historial")
        }
    }
}