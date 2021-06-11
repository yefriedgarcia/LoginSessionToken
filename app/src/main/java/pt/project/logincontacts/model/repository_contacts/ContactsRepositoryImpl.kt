package pt.project.logincontacts.model.repository_contacts
import android.provider.SyncStateContract
import pt.project.crm_pruebatecnica.constants.Constants
import pt.project.logincontacts.dtos.contacts_model.ContactsData
import pt.project.logincontacts.dtos.login_auth_model.Result
import pt.project.logincontacts.network.APIRequest
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContactsRepositoryImpl @Inject constructor(private val api: APIRequest): ContactsRepository {

    override suspend fun getContacts(result: Result):
            Response<ContactsData> = api.getContacts(Constants.OPERATION_QUERY, result.sessionName, Constants.QUERY)

}