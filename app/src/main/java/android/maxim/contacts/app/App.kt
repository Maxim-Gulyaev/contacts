package android.maxim.contacts.app

import android.app.Application
import android.maxim.contacts.di.AppComponent
import android.maxim.contacts.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}