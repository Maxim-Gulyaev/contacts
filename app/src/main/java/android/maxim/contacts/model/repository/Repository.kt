package android.maxim.contacts.model.repository

import android.app.Application
import android.content.Context
import android.database.Cursor
import android.maxim.contacts.app.App
import android.maxim.contacts.di.component.DaggerAppComponent
import android.maxim.contacts.di.module.AppModule
import android.maxim.contacts.model.database.Contact
import android.maxim.contacts.model.database.ContactDao
import android.maxim.contacts.model.database.ContactsDatabase
import android.maxim.contacts.ui.activity.MainActivity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class Repository @Inject constructor(/*private val contactDao: ContactDao*/) {

    @Inject
    lateinit var context: Application

    @Inject
    lateinit var contactDao: ContactDao

    init {
        val appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(App().getAppContext()))
            .build()
        appComponent.injectRepository(this)
    }

    fun insertContact(contact: Contact) {
        contactDao.insertContact(contact)
    }

    fun updateContact(contact: Contact) {
        contactDao.updateContact(contact)
    }

    fun getContact(): Single<List<Contact>> {
        return contactDao.getContact()
    }

    fun getContactName(): Cursor {
        return contactDao.getContactName()
    }

    fun deleteContact(contact: Contact) {
        contactDao.deleteContact(contact)
    }
}



