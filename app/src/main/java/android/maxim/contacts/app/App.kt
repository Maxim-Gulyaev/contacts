package android.maxim.contacts.app

import android.app.Application
import android.maxim.contacts.di.component.AppComponent
import android.maxim.contacts.di.component.DaggerAppComponent
import android.maxim.contacts.di.module.AppModule
import android.maxim.contacts.model.database.ContactsDatabase

class App: Application() {

    lateinit var appComponent: AppComponent
    private var contactsDatabase: ContactsDatabase? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(applicationContext)).build()
        contactsDatabase = ContactsDatabase.getInstance(applicationContext)
    }

    fun getAppContext(): App {
        return App()
    }
}