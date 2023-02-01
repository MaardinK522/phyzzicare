package com.mkproduction.therapist.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mkproduction.therapist.R
import com.mkproduction.therapist.models.UserSignupModel
import com.mkproduction.therapist.utilities.ServerClient
import retrofit2.Call
import retrofit2.Response


class SignUp : AppCompatActivity(), retrofit2.Callback<String> {
    private lateinit var mLogInButton: Button
    private lateinit var mSignupButton: Button
    private lateinit var mUserEmailEditText: EditText
    private lateinit var mUserPasswordEditText: EditText
    private lateinit var mUserRepeatPasswordEditText: EditText
    private lateinit var mDoctorBannerLinearLayout: LinearLayout

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        // attaching the views to every elements
        findViews()
        // shared preferences
        val sharedPreferences =
            this.getSharedPreferences("ServerUrlSharedPref", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("server_url", "http://192.168.0.1:6969").apply()
        // Attaching click listeners
        mSignupButton.setOnClickListener {
            val userEmail = mUserEmailEditText.text.toString().trim()
            val userPassword = mUserPasswordEditText.text.toString().trim()
            val userRepeatedPassword = mUserRepeatPasswordEditText.text.toString().trim()
            if (userEmail.isNotEmpty() || userEmail.isNotBlank() || userPassword.isNotBlank() || userPassword.isNotEmpty() || userRepeatedPassword.isNotBlank() || userRepeatedPassword.isNotEmpty()) {
                if (userPassword == userRepeatedPassword) {
                    Toast.makeText(
                        this@SignUp,
                        "Email: $userEmail|| Password: $userPassword",
                        Toast.LENGTH_SHORT
                    ).show()
                    val serverSignUpRequest =
                        ServerClient.Companion.Properties(sharedPreferences).client.signUpUser(
                            UserSignupModel(userEmail, userPassword)
                        )
                    serverSignUpRequest.enqueue(this@SignUp)
                }
                return@setOnClickListener
            }
            Toast.makeText(this@SignUp, "Fields are empty", Toast.LENGTH_SHORT).show()
        }
        mLogInButton.setOnClickListener {
            startActivity(Intent(this@SignUp, LoginActivity::class.java))
//            startActivity(Intent(this@SignUp, LoginActivity::class.java),ActivityOptions.makeSceneTransitionAnimation(this@SignUp,mLogInButton,R.string.mk_productions_signup_button_transition_name.toString()).toBundle())
        }
        mDoctorBannerLinearLayout.setOnLongClickListener {
            startActivity(Intent(this@SignUp, ServerUrlHandlerActivity::class.java))
            return@setOnLongClickListener true
        }
    }

    private fun findViews() {
        mLogInButton = findViewById(R.id.signup_activity_login_button)
        mSignupButton = findViewById(R.id.signup_activity_signup_button)
        mUserEmailEditText = findViewById(R.id.signup_activity_user_email)
        mUserPasswordEditText = findViewById(R.id.signup_activity_doctor_password)
        mUserRepeatPasswordEditText = findViewById(R.id.signup_activity_doctor_reapeat_password)
        mDoctorBannerLinearLayout = findViewById(R.id.signup_activity_logo)
    }

    override fun onResponse(call: Call<String>, response: Response<String>) {
        Log.d("Server Response from the server : ", "onResponse: $response")
        try {
            Toast.makeText(this@SignUp, "${response.body()}", Toast.LENGTH_SHORT).show()
            Log.d("onReponse", "onResponse: ")
        } catch (e: java.lang.Exception) {
            Log.d("onResponse Failed catch block", "onResponse: $e")
        }
    }

    override fun onFailure(call: Call<String>, t: Throwable) {
        Log.e("Server Failure output: ", "onFailure: $t")
    }
}