package pt.project.logincontacts.viewmodels.login

import android.util.Log
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pt.project.crm_pruebatecnica.constants.Constants.Companion.ACCESS_KEY
import pt.project.crm_pruebatecnica.dtos.auth.AuthData
import pt.project.logincontacts.dtos.login_auth_model.LoginAuth
import pt.project.logincontacts.model.repository_auth.AuthRepositoryImpl
import pt.project.logincontacts.network.sealed_response.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor (private val repositoryImpl: AuthRepositoryImpl) : ViewModel() {

    private val _accessKeyRes:MutableLiveData<Response<AuthData>> = MutableLiveData()
    val accessKeyRes: LiveData<Response<AuthData>>
        get()  = _accessKeyRes

    private val _loginRes:MutableLiveData<Response<LoginAuth>> = MutableLiveData()
    val loginRes: LiveData<Response<LoginAuth>>
        get()  = _loginRes

    private val _tokenMD5:MutableLiveData<String> = MutableLiveData()
    val tokenMD5: LiveData<String>
        get()  = _tokenMD5


    fun getChallenge(
        username : String
    ) = viewModelScope.launch {
        repositoryImpl.getChallenge(username).let {
            if(it.isSuccessful){
                if(it.body()!!.success){
                    _accessKeyRes.postValue(Response.Success(it.body()!!))
                    _tokenMD5.postValue(repositoryImpl.getmd5(it.body()!!.result.token+ACCESS_KEY))
                    Log.d("TAG", "getChallenge: ")
                }else{
                    _accessKeyRes.postValue(Response.Failure(true,null,null))
                }
            }

        }
        }

    fun getLogin(
        username: String,
        accesskey: String
    ) = viewModelScope.launch {
        repositoryImpl.getLogin(username,accesskey).let {
            if(it.isSuccessful){
                    repositoryImpl.insertDB(it.body()!!.result)
                    _loginRes.postValue(Response.Success(it.body()!!))
                }else{
                    _loginRes.postValue(Response.Failure(it.isSuccessful,null,it.errorBody()))
                }
        }
    }


}

