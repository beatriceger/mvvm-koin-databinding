package com.example.testkoinmvvm.activities.main

import android.content.IntentFilter
import android.databinding.DataBindingUtil
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.testkoinmvvm.R
import com.example.testkoinmvvm.databinding.ActivityMainBinding
import com.example.testkoinmvvm.service.NetworkService

class MainActivity : AppCompatActivity(), NetworkService.ConnectivityReceiverListener {

    lateinit var navController: NavController
    lateinit var navHostFragment: NavHostFragment
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerReceiver(NetworkService(this), IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.mainBottomNavigation, navHostFragment.navController)
    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        if (!isConnected) {
            showAlertDialog()
        }
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Internet connection")
        builder.setMessage("No internet connection!!!")
        builder.setPositiveButton(android.R.string.yes) { _, _ -> }
        builder.show()
    }

    override fun onResume() {
        super.onResume()
        NetworkService.connectivityReceiverListener = this
    }

    override fun onBackPressed() {
    }
}
