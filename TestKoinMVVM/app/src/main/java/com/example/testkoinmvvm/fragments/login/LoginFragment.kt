package com.example.testkoinmvvm.fragments.login

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testkoinmvvm.R
import com.example.testkoinmvvm.activities.main.MainActivity
import com.example.testkoinmvvm.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel by viewModel<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLoginAction()
        initRegisterAction()
        observeShowMainScreen()
        observeUserIdentification()
    }

    private fun initLoginAction() {
        binding.loginBtn.setOnClickListener {
            loginViewModel.loginUser(binding.name.text.toString().trim(), binding.password.text.toString().trim())
        }
    }

    private fun observeShowMainScreen() {
        loginViewModel.showMainScreen.observe(this, Observer { showMainScreen ->
            if (showMainScreen!!) {
                (context as MainActivity).navController.navigate(R.id.action_loginFragment_to_homeFragment, null)
            }
        })
    }

    private fun initRegisterAction() {
        binding.registerBtn.setOnClickListener {
            (context as MainActivity).navController.navigate(
                R.id.action_loginFragment_to_registerFragment,
                null
            )
        }
    }

    private fun observeUserIdentification() {
        loginViewModel.showWrongUserMessage.observe(this, Observer<String> { message ->
            textView2.text = message
        })
    }
}
