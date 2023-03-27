package android.maxim.contacts.model.repository

import android.app.Application
import android.content.Context
import android.database.Cursor
import android.maxim.contacts.app.App
import android.maxim.contacts.model.database.Contact
import android.maxim.contacts.model.database.ContactDao
import android.maxim.contacts.model.database.ContactsDatabase
import android.maxim.contacts.ui.activity.MainActivity
import javax.inject.Inject

class Repository @Inject constructor(private val contactDao: ContactDao) {

    @Inject
    lateinit var context: Application

    // getInstance method used two times, here and in main activity
    // issue need to be solved
    fun insertContact(contact: Contact) {
        val db = ContactsDatabase.getInstance(context)?.contactDao()!!
        db.insertContact(contact)
    }

    fun updateContact(contact: Contact) {
        contactDao.updateContact(contact)
    }

    fun getContact(): Cursor {
        return contactDao.getContact()
    }

    fun getContactName(): Cursor {
        return contactDao.getContactName()
    }

    fun deleteContact(contact: Contact) {
        contactDao.deleteContact(contact)
    }
}



