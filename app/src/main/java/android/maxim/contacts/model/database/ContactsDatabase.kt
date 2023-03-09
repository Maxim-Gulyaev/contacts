package android.maxim.contacts.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class ContactsDatabase: RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {
        private var INSTANCE: ContactsDatabase? = null

        fun getInstance(context: Context):ContactsDatabase? {
            if (INSTANCE == null) {
                synchronized(ContactsDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    ContactsDatabase::class.java,
                    name = "contacts.db")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}