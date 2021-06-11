package pt.project.logincontacts.model.repository_contacts
import pt.project.logincontacts.dtos.contacts_model.ContactsData
import pt.project.logincontacts.dtos.login_auth_model.Result
import pt.project.logincontacts.network.APIRequest
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContactsRepositoryImpl @Inject constructor(private val api: APIRequest): ContactsRepository {

    override suspend fun getContacts(result: Result):
            Response<ContactsData> = api.getContacts("query", result.sessionName, "select * from Contacts;")

}