package com.mkproduction.therapist.activities

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.mkproduction.therapist.R

class LoginActivity : AppCompatActivity() {
    private lateinit var mLoginButton: MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_login)
        val button = findViewById<Button>(R.id.login_activity_signup_button)
        button.setOnClickListener {
            startActivity(
                Intent(this@LoginActivity, SignUp::class.java),
                ActivityOptions.makeSceneTransitionAnimation(
                    this, Pair.create(
                        button, R.string.mk_productions_login_button_transition_name.toString()
                    ), Pair.create(
                        findViewById(R.id.login_activity_logo_2),
                        R.string.mk_productions_doctor_text_transition_name.toString()
                    )
                ).toBundle()
            )
        }
        mLoginButton = findViewById(R.id.login_activity_login_button)
        mLoginButton.setOnClickListener {
            startActivity(Intent(this@LoginActivity, HomePageActivity::class.java))
        }
    }
}

