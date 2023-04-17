package android.maxim.contacts.model.database

import android.database.Cursor
import androidx.room.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

@Dao
interface ContactDao {

    //TODO: Make contacts placing in an alphabetical order

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertContact(contact: Contact)

    @Update
    fun updateContact(contact: Contact)

    @Query("SELECT * FROM contacts")
    fun getContact(): Single<List<Contact>>

    @Query("SELECT firstName, lastName FROM contacts")
    fun getContactName(): Cursor

    @Delete
    fun deleteContact(contact: Contact)

}