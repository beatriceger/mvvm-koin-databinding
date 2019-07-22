package com.example.testkoinmvvm.fragments.register

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    var showMainScreen = MutableLiveData<Boolean>()
    var showWrongUserMessage = MutableLiveData<String>()

    fun validateUser(email: String, password: String) {
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            showWrongUserMessage.value = " Please fill with data!"
            showMainScreen.value = false
        } else {
            showMainScreen.value = true
        }
    }
}