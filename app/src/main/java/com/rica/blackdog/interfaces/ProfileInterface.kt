package com.rica.blackdog.interfaces

import com.parse.ParseObject

interface ProfileInterface {
    fun onSuccess(profile: ParseObject)
}