package android.maxim.contacts.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String
)