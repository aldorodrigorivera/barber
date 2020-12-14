package com.rica.blackdog.interfaces

import com.parse.ParseObject
import java.util.ArrayList

interface HomeInterface {
    fun onSuccess(services: ArrayList<ParseObject>)
    fun onClick(service: ParseObject)
}