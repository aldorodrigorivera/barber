package com.rica.blackdog.presenters

import android.content.Context
import com.parse.ParseObject
import com.parse.ParseQuery
import com.rica.blackdog.interfaces.GenericInterface
import com.rica.blackdog.interfaces.HomeInterface
import java.util.ArrayList

class HomePresenter(
    private val context: Context,
    private val mGeneric:GenericInterface,
    private val mInterface: HomeInterface
) {

    fun getAllServices() {
        mGeneric.onLoading()
        val query: ParseQuery<ParseObject> = ParseQuery("Service")
        query.whereEqualTo("active",true)
        query.findInBackground { objects, e ->
            mGeneric.onLoadingDone()
            if(objects != null  && e == null){
                mInterface.onSuccess(objects as ArrayList<ParseObject>)
            }else{
                mGeneric.onError("Hubo un error no se pudo obtener los servicios disponibles")
            }
        }
    }


}