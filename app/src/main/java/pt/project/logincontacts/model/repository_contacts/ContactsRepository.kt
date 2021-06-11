package pt.project.logincontacts.model.repository_contacts

import pt.project.logincontacts.dtos.contacts_model.ContactsData
import pt.project.logincontacts.dtos.login_auth_model.Result
import retrofit2.Response

interface ContactsRepository {

    suspend fun getContacts(result: Result): Response<ContactsData>
}