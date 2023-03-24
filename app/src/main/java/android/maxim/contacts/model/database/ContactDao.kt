package android.maxim.contacts.model.database

import android.database.Cursor
import androidx.room.*
import javax.inject.Inject

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