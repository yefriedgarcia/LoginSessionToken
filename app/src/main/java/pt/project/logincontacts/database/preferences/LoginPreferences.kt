package pt.project.logincontacts.database.preferences
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "token_storage")


class LoginPreferences(context: Context)  {

    private val dataStore = context.dataStore
    private val applicationContext = context.applicationContext

    val token: Flow<String?>
        get() = dataStore.data.map {
            it[TOKEN_SAVED]
        }

    suspend fun saveToken(token: String){
        dataStore.edit{
            it[TOKEN_SAVED] = token
        }
    }

    companion object{
        private val TOKEN_SAVED = stringPreferencesKey("token_saved")
    }
}