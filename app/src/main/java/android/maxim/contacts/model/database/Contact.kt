package android.maxim.contacts.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var firstName: String,
    var lastName: String,
    var phoneNumber: String,
    var email: String
)