package com.rica.blackdog.interfaces

import com.parse.ParseObject
import java.util.ArrayList

interface PointsOfSaleInterface {
    fun onSuccess(services: ArrayList<ParseObject>)
    fun onClick(pointOfSale: ParseObject)
}