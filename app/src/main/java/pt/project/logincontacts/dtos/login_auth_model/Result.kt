package pt.project.logincontacts.dtos.login_auth_model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "session")
data class Result(

    val sessionName: String,
    @PrimaryKey(autoGenerate = false)
    val userId: String,
    val version: String,
    val vtigerVersion: String
)