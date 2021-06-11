package pt.project.logincontacts.database

import androidx.room.Database
import androidx.room.RoomDatabase
import pt.project.logincontacts.database.entities.Contacts

@Database(entities = [Contacts::class], version = 1, exportSchema = false )
abstract class DBHandler: RoomDatabase() {

    abstract fun contactsDao(): ContactsDAO
}