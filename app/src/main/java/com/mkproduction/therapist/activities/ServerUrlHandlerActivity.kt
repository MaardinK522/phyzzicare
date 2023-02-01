package com.mkproduction.therapist.activities

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.mkproduction.therapist.R
import com.mkproduction.therapist.utilities.ServerClient

class ServerUrlHandlerActivity : AppCompatActivity() {

    private lateinit var mServerUrlEdiText: TextInputEditText
    private lateinit var mRegisterServerUrlButton: MaterialButton
    private lateinit var mSharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_server_url_handler)
        // finding the views
        findViews()
        // assigning the shared preferences
        mSharedPreferences = this.getSharedPreferences("ServerUrlSharedPref", Context.MODE_PRIVATE);
        // assigning the server url
        mServerUrlEdiText.setText(
            ServerClient.Companion.Properties(
                mSharedPreferences
            ).getServerUrl()
        )
        // clicks
        mRegisterServerUrlButton.setOnClickListener {
            val serverUrl = mServerUrlEdiText.text.toString().trim()
            if (serverUrl.isNotBlank() && serverUrl.isNotEmpty()) {
                mSharedPreferences.edit().putString("server_url", serverUrl).apply()
                Toast.makeText(
                    this@ServerUrlHandlerActivity,
                    "The app is serving to $serverUrl",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
                return@setOnClickListener
            }
            Toast.makeText(
                this@ServerUrlHandlerActivity, "Please fill the server filled.!", Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun findViews() {
        mServerUrlEdiText = findViewById(R.id.activity_server_handler_server_edittext)
        mRegisterServerUrlButton = findViewById(R.id.activity_server_handler_register_button)
    }
}