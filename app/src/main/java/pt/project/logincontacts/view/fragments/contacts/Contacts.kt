package pt.project.logincontacts.view.fragments.contacts

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import pt.project.logincontacts.databinding.ContactsFragmentBinding
import pt.project.logincontacts.dtos.contacts_model.Result
import pt.project.logincontacts.network.sealed_response.Response
import pt.project.logincontacts.view.adapters.ContactsAdapter
import pt.project.logincontacts.viewmodels.contacts.ContactsViewModel

@AndroidEntryPoint
class Contacts : Fragment() {

    private lateinit var viewModel: ContactsViewModel
    private var _binding: ContactsFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ContactsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        _binding = ContactsFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel by activityViewModels<ContactsViewModel>()

        viewModel.getContacts()
        viewModel.contactsData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Response.Failure -> {
                    Log.d("TAG", "onViewCreated3: " + it.errorBody)
                }
                is Response.Success -> {
                    if(it.value.success){
                        initRecycler(it.value.result)
                    }
                }
            }
        })
    }

    fun initRecycler(result: List<Result>) {
        adapter = ContactsAdapter(result)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

    }

}