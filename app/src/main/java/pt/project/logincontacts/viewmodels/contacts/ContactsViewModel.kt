package pt.project.logincontacts.viewmodels.contacts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pt.project.logincontacts.database.ContactsDAO
import pt.project.logincontacts.dtos.contacts_model.ContactsData
import pt.project.logincontacts.model.repository_contacts.ContactsRepositoryImpl
import pt.project.logincontacts.network.sealed_response.Response
import javax.inject.Inject

@HiltViewModel
class ContactsViewModel @Inject constructor(private val repository: ContactsRepositoryImpl,private val dao: ContactsDAO) : ViewModel() {

    private val _contactsData:MutableLiveData<Response<ContactsData>> = MutableLiveData()
    val contactsData:LiveData<Response<ContactsData>>
        get() = _contactsData

    fun getContacts(){
        viewModelScope.launch {
            repository.getContacts(dao.getSessionName()).let {
                if(it.isSuccessful){
                    _contactsData.postValue(Response.Success(it.body()!!))
                }else{
                    _contactsData.postValue(Response.Failure(true, null, it.errorBody()))
                }
            }
        }
    }
}