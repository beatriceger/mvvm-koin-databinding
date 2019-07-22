package com.example.testkoinmvvm.app.di

import com.example.testkoinmvvm.fragments.home.HomeViewModel
import com.example.testkoinmvvm.fragments.login.LoginViewModel
import com.example.testkoinmvvm.fragments.profile.ProfileViewModel
import com.example.testkoinmvvm.fragments.register.RegisterViewModel
import com.example.testkoinmvvm.fragments.settings.SettingsViewModel
import com.example.testkoinmvvm.fragments.splash.SplashViewModel
import com.example.testkoinmvvm.service.NetworkService
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


val appModule: Module = module {

    viewModel { SplashViewModel() }
    viewModel { LoginViewModel() }
    viewModel { RegisterViewModel() }
    viewModel { ProfileViewModel() }
    viewModel { HomeViewModel() }
    viewModel { SettingsViewModel(get()) }
//    single { NetworkService(get()) }
}
