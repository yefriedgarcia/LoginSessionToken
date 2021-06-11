package pt.project.logincontacts.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pt.project.logincontacts.dtos.login_auth_model.Result

@Dao
interface ContactsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(session: Result)

    @Query("SELECT * FROM SESSION ORDER BY sessionName DESC LIMIT 1")
    suspend fun getSessionName():Result
}