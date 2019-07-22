package com.example.testkoinmvvm

import android.app.Application
import com.example.testkoinmvvm.app.di.appModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

class TestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(appModule)
        }
    }
}