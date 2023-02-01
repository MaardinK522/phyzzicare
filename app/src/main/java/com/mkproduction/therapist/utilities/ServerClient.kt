package com.mkproduction.therapist.utilities

import android.content.SharedPreferences
import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServerClient {
    companion object {
        class Properties(private val sharedPreferences: SharedPreferences) {
            private val retrofit: Retrofit =
                Retrofit.Builder().baseUrl(getServerUrl())
                    .addConverterFactory(GsonConverterFactory.create()).build()
            val client: ServerClientInterface = retrofit.create(ServerClientInterface::class.java)
            fun getServerUrl(): String {
                Log.e(
                    "SERVER URL",
                    "getServerUrl: ${sharedPreferences.getString("server_url", "")}"
                )
                return sharedPreferences.getString("server_url", "").toString()
            }
        }
    }
}