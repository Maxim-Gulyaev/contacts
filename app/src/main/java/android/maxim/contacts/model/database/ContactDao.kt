package android.maxim.contacts.model.database

import androidx.room.*

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertContact(contact: Contact)

    @Update
    fun updateContact(contact: Contact)

    @Query("SELECT * FROM contacts")
    fun getContact(): Contact

    @Delete
    fun deleteContact(contact: Contact)

}