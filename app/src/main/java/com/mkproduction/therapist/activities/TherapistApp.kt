package com.mkproduction.therapist.activities

import android.app.Application
import com.google.android.material.color.DynamicColors

class TherapistApp : Application() {
    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}