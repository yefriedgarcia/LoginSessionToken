package pt.project.logincontacts.database

import androidx.room.Database
import androidx.room.RoomDatabase
import pt.project.logincontacts.dtos.login_auth_model.Result

@Database(entities = [Result::class], version = 1, exportSchema = false )
abstract class DBHandler: RoomDatabase() {

    abstract fun contactsDao(): ContactsDAO
}