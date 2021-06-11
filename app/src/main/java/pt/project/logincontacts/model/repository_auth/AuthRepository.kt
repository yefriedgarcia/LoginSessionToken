package pt.project.logincontacts.model.repository_auth

import pt.project.crm_pruebatecnica.dtos.auth.AuthData
import pt.project.logincontacts.dtos.login_auth_model.LoginAuth
import pt.project.logincontacts.dtos.login_auth_model.Result
import retrofit2.Response


interface AuthRepository {

suspend fun getChallenge(userName: String,): Response<AuthData>
suspend fun getLogin(username: String, accesskey: String): Response<LoginAuth>
suspend fun getmd5(token:String):String
suspend fun insertDB(result: Result)

}