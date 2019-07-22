package com.example.testkoinmvvm.fragments.splash

import android.arch.lifecycle.ViewModel
import com.example.testkoinmvvm.R
import com.example.testkoinmvvm.activities.main.MainActivity
import java.util.*
import kotlin.concurrent.timerTask

class SplashViewModel : ViewModel() {

    val timer = Timer()

    fun showNextScreen(activity: MainActivity) {
        if (checkUserIsLoggedIn(activity)) {
            timer.schedule(timerTask {
                showMainScreen(activity)
            }, 3000)
        } else {
            timer.schedule(timerTask { showLoginScreen(activity) }, 3000)
        }
    }

    private fun checkUserIsLoggedIn(activity: MainActivity): Boolean {
        return false
    }

    private fun showLoginScreen(activity: MainActivity) {
        activity.navController.navigate(R.id.action_splashFragment_to_loginFragment2, null)
    }

    private fun showMainScreen(activity: MainActivity) {
        activity.navController.navigate(R.id.action_splashFragment_to_navigation2, null)
    }
}