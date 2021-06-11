package pt.project.logincontacts.database.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "contacts")
data class Contacts(

    @PrimaryKey(autoGenerate = false)
    val id: String

)