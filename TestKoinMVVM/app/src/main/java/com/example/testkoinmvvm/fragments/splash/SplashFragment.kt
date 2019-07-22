package com.example.testkoinmvvm.fragments.splash

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testkoinmvvm.activities.main.MainActivity
import com.example.testkoinmvvm.databinding.FragmentSplashBinding
import org.koin.android.viewmodel.ext.android.viewModel


class SplashFragment : Fragment() {

    val splashViewModel by viewModel<SplashViewModel>()
    private lateinit var binding: FragmentSplashBinding
    // val mainActivity :MainActivity  by inject { parametersOf(activity) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashViewModel.showNextScreen(context as MainActivity)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }
}

