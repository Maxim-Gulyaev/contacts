package android.maxim.contacts.model.database

import android.database.Cursor
import javax.inject.Inject

//Сделал временно, чтобы запустить AddFragment

class ContactDaoImpl @Inject constructor(): ContactDao {
    override fun insertContact(contact: Contact) {
        TODO("Not yet implemented")
    }

    override fun updateContact(contact: Contact) {
        TODO("Not yet implemented")
    }

    override fun getContact(): Cursor {
        TODO("Not yet implemented")
    }

    override fun getContactName(): Cursor {
        TODO("Not yet implemented")
    }

    override fun deleteContact(contact: Contact) {
        TODO("Not yet implemented")
    }

}