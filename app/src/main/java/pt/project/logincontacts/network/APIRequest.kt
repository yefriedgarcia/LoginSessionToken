package pt.project.logincontacts.network

import pt.project.crm_pruebatecnica.dtos.auth.AuthData
import pt.project.logincontacts.dtos.login_auth.LoginAuth
import retrofit2.Response
import retrofit2.http.*

interface APIRequest {

    @GET("webservice.php")
    suspend fun getchallenge(@Query("operation") operation: String,
                             @Query("username") username: String): Response<AuthData>

    @FormUrlEncoded
    @POST("webservice.php")
    suspend fun login(
        @Field("operation") operation: String,
        @Field("username") username: String,
        @Field("accessKey") accessKey: String
    ): Response<LoginAuth>


}