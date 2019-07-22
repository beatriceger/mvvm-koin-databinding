package com.example.testkoinmvvm.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast

class NetworkService(var context: Context) : BroadcastReceiver() {

    companion object {
        const val CONNECTIVITY_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE"
        const val WIFI_STATE_CHANGED = "android.net.wifi.WIFI_STATE_CHANGED"
        var connectivityReceiverListener: ConnectivityReceiverListener? = null
    }

    private var isInternet = true

    override fun onReceive(context: Context, intent: Intent?) {
        if (intent?.action == CONNECTIVITY_CHANGE || intent?.action == WIFI_STATE_CHANGED) {
            //context.startService(intent)
            if (isNetworkConnected(context)) {
                if (!isInternet) {
                    isInternet = true
                    Log.i("CONNECTION", "Internet on")
                 //   Toast.makeText(context, "NO internet", Toast.LENGTH_SHORT).show()
                }
            } else {
                if (isInternet) {
                    isInternet = false
                 //   Toast.makeText(context, "YES internet", Toast.LENGTH_SHORT).show()
                    Log.i("CONNECTION", "Internet off")
                }
            }
        }
        connectivityReceiverListener!!.onNetworkConnectionChanged(isInternet)
    }

    private fun isNetworkConnected(context: Context): Boolean {
        val connManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connManager.activeNetworkInfo ?: return false
        return networkInfo.isConnected
    }

    interface ConnectivityReceiverListener {
        fun onNetworkConnectionChanged(isConnected: Boolean)
    }
}
