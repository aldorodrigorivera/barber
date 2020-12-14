package com.rica.blackdog.app

import android.app.Application
import com.parse.Parse
import com.parse.ParseInstallation

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        //    -----------------------------------------------------------     DECLARA TODOS LOS MODELOS
        //        ParseObject.registerSubclass(Contract::class.java)
        //        ParseObject.registerSubclass(Payment::class.java)
        //        ParseObject.registerSubclass(Unity::class.java)
        //        ParseObject.registerSubclass(Bill::class.java)
        //        ParseObject.registerSubclass(Complex::class.java)
        //        ParseObject.registerSubclass(Bulletin::class.java)
        //        ParseObject.registerSubclass(Directory::class.java)
        //        ParseObject.registerSubclass(Ticket::class.java)
        //        ParseObject.registerSubclass(Message::class.java)

        Parse.initialize(
            Parse.Configuration.Builder(applicationContext)
            .applicationId("KHsXYICKjMkN6oVRUgwuj5ZTLC586l8RpOg2NbmK")
            .clientKey("EZgrUsP0Ejx5DuphV5nhCEIsehPj3ZtidOOC3EX5")
            .server("https://parseapi.back4app.com/")
            .build()
        )
        ParseInstallation.getCurrentInstallation().saveInBackground()
    }
}