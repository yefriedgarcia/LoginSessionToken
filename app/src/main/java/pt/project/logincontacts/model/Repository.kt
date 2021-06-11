package pt.project.logincontacts.model

import androidx.lifecycle.LiveData
import pt.project.crm_pruebatecnica.dtos.auth.AuthData
import pt.project.logincontacts.database.entities.Contacts
import pt.project.logincontacts.dtos.login_auth.LoginAuth
import retrofit2.Response


interface Repository {

suspend fun insertContacts(contacts: Contacts)
suspend fun getChallenge(operation: String, userName: String,): Response<AuthData>
suspend fun getLogin(operation: String, username: String, accesskey: String): Response<LoginAuth>
suspend fun getmd5(token:String):String

}