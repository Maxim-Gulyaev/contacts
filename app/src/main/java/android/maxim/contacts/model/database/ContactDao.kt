package android.maxim.contacts.model.database

import android.database.Cursor
import android.maxim.contacts.viewmodels.AddViewModel
import android.maxim.contacts.viewmodels.DetailsViewModel
import android.maxim.contacts.viewmodels.EditViewModel
import android.maxim.contacts.viewmodels.ListViewModel
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertContact(contact: Contact)

    @Update
    fun updateContact(contact: Contact)

    @Query("SELECT * FROM contacts")
    fun getContact(): Cursor

    @Query("SELECT firstName, lastName FROM contacts")
    fun getContactName(): Cursor

    @Delete
    fun deleteContact(contact: Contact)

}