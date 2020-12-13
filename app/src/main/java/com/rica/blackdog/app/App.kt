package com.rica.blackdog.app

import android.app.Application

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

        /*Parse.initialize(Parse.Configuration.Builder(applicationContext)
            .applicationId("BrounieApp")
            .clientKey("C4suYZKkyRMYPGR7fEae")
            .server("https://brewsintown.brounieapps.com/parse/")
            .build()
        )
        ParseInstallation.getCurrentInstallation().saveInBackground()*/
    }
}