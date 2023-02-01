package com.mkproduction.therapist.splashes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.mkproduction.therapist.R
import com.mkproduction.therapist.activities.SignUp

@SuppressLint("CustomSplashScreen")
class AppStartingSplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_starting_splash)
        // starting activity
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(
                Intent(this@AppStartingSplashActivity, SignUp::class.java),
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this,
                    findViewById<TextView>(R.id.app_starting_splash_activity_textview),
                    getString(R.string.mk_productions_doctor_text_transition_name)
                ).toBundle()
            )
            finish()
        }, 1500)
    }

}