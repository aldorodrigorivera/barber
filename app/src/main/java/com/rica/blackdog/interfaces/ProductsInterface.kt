package com.rica.blackdog.interfaces

import com.parse.ParseObject

interface ProductsInterface {
    fun onSuccess(products: ArrayList<ParseObject>)
}