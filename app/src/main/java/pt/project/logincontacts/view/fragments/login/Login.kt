package pt.project.logincontacts.view.fragments.login

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import pt.project.logincontacts.R

import pt.project.logincontacts.databinding.LoginFragmentBinding

import pt.project.logincontacts.network.sealed_response.Response
import pt.project.logincontacts.view.activities.HomeActivity
import pt.project.logincontacts.viewmodels.login.LoginViewModel

@AndroidEntryPoint
class Login : Fragment() {


    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel by activityViewModels<LoginViewModel>()

        viewModel.getChallenge("prueba")
        viewModel.loginRes.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Response.Success -> {
                   // binding.etAccessKey.error = it.value.success
                    if(it.value.success){

                        activity.let {
                            it?.startActivity(Intent(requireContext(), HomeActivity::class.java))
                            it?.finish()
                        }
                    }

                  //  findNavController().navigate(R.id.action_login_to_homeActivity)

                    Log.d("TAG", "onViewCreated:" + it.value.result)//.value.success)
                }
                is Response.Failure -> {
                    Log.d("TAG", "onViewCreated: " + it.isNetworkError)
                }
            }
        })

        viewModel.tokenMD5.observe(viewLifecycleOwner, Observer { token ->
            binding.etAccessKey.setText(token)
        })
        viewModel.accessKeyRes.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Response.Success -> {
                    Log.d("TAG", "onViewCreated:suc " + it.value.result.token)
                }
                is Response.Failure -> {
                    Log.d("TAG", "onViewCreated:err " + it.errorCode)
                }
            }
        })

        binding.apply {
            btnToken.setOnClickListener { viewModel.getChallenge("prueba") }
            btnLogin.setOnClickListener {
                viewModel.getLogin(
                    etUsername.text.toString(),
                    etAccessKey.text.toString()
                )
            }
        }

    }

}

