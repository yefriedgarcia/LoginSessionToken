package pt.project.logincontacts.model.repository_auth


import pt.project.crm_pruebatecnica.constants.Constants
import pt.project.crm_pruebatecnica.dtos.auth.AuthData
import pt.project.logincontacts.Utils.Companion.md5
import pt.project.logincontacts.database.ContactsDAO
import pt.project.logincontacts.dtos.login_auth_model.LoginAuth
import pt.project.logincontacts.dtos.login_auth_model.Result
import pt.project.logincontacts.network.APIRequest
import retrofit2.Response

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(private val api: APIRequest, private val dao: ContactsDAO) : AuthRepository {

    override suspend fun getLogin(
       username: String, accesskey: String
    ): Response<LoginAuth> = api.login(Constants.OPERATION_LOGIN, username, accesskey)

    override suspend fun getmd5(token: String): String = md5(token)

    override suspend fun insertDB(result: Result) {
        dao.insert(result)
    }

    override suspend fun getChallenge(
        userName: String,
    ): Response<AuthData> = api.getchallenge(Constants.OPERATION_CHALLENGE, userName)


}