package android.maxim.contacts.app

import android.app.Application
import android.maxim.contacts.di.AppComponent
import android.maxim.contacts.di.AppModule
import android.maxim.contacts.di.DaggerAppComponent
import android.maxim.contacts.model.database.ContactDaoImpl
import android.maxim.contacts.model.repository.Repository

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this, repository = Repository(contactDao = ContactDaoImpl())))
            .build()
    }
}