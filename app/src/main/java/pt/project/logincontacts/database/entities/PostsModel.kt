package pt.project.logincontacts.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Constructor

data class PostsModel(

    val userId: String,
    val id: String,
    val title: String,
    val body: String,

)
