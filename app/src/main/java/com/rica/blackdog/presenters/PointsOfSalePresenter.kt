package com.rica.blackdog.presenters

import android.content.Context
import com.parse.ParseObject
import com.parse.ParseQuery
import com.parse.ParseUser
import com.rica.blackdog.interfaces.GenericInterface
import com.rica.blackdog.interfaces.LoginInterface
import com.rica.blackdog.interfaces.PointsOfSaleInterface
import java.util.ArrayList


class PointsOfSalePresenter (
        private val context: Context,
        private val mGeneric: GenericInterface,
        private val mInterface:PointsOfSaleInterface
        ) {


    /**
     * @description This function is to get all poits available
     */
    fun getPointsOfSale(){
        mGeneric.onLoading()
        val query: ParseQuery<ParseObject> = ParseQuery("PointOfSale")
        query.whereEqualTo("active",true)
        query.findInBackground { objects, e ->
            mGeneric.onLoadingDone()
            if(objects != null  && e == null){
                mInterface.onSuccess(objects as ArrayList<ParseObject>)
            }else{
                mGeneric.onError("Hubo un error no se pudo obtener las barberías disponibles")
            }
        }
    }

}