package com.example.testkoinmvvm.fragments.register

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testkoinmvvm.R
import com.example.testkoinmvvm.activities.main.MainActivity
import com.example.testkoinmvvm.databinding.FragmentRegisterBinding
import org.koin.android.viewmodel.ext.android.viewModel

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    val registerViewModel by viewModel<RegisterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRegisterAction()
        observeShowMainScreen()
        observeUserRegistration()
    }

    private fun observeShowMainScreen() {
        registerViewModel.showMainScreen.observe(this, Observer { showMainScreen ->
            if (showMainScreen!!) {
                (context as MainActivity).navController.navigate(R.id.action_registerFragment_to_homeFragment, null)
            }
        })
    }

    private fun initRegisterAction() {
        binding.registerBtn.setOnClickListener {
            registerViewModel.validateUser(binding.mail.text.toString().trim(), binding.password.text.toString().trim())
        }
    }

    private fun observeUserRegistration() {
        registerViewModel.showWrongUserMessage.observe(this, Observer<String> { message ->
            binding.textView2.text = message
        })
    }

}
