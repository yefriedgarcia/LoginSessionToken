package pt.project.logincontacts.model.repository_auth


import pt.project.crm_pruebatecnica.dtos.auth.AuthData
import pt.project.logincontacts.Utils.Companion.md5
import pt.project.logincontacts.database.entities.Contacts
import pt.project.logincontacts.database.entities.PostsModel
import pt.project.logincontacts.dtos.login_auth.LoginAuth
import pt.project.logincontacts.model.Repository
import pt.project.logincontacts.network.APIRequest
import retrofit2.Response

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(private val api: APIRequest) : Repository {

    override suspend fun getLogin(
        operation: String, username: String, accesskey: String
    ): Response<LoginAuth> = api.login(operation, username, accesskey)

    override suspend fun getmd5(token: String): String = md5(token)

    override suspend fun insertContacts(contacts: Contacts) {
        TODO("Not yet implemented")
    }

    override suspend fun getChallenge(
        operation: String,
        userName: String,
    ): Response<AuthData> = api.getchallenge(operation, userName)


}