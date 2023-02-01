package com.mkproduction.therapist.utilities

import com.mkproduction.therapist.models.UserSignupModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query
import java.sql.Date

interface ServerClientInterface {
    @Headers("Content-Type:application/json", "ngrok-skip-browser-warning:1231")
    @POST("/register/user_signup")
    fun signUpUser(
        @Body user: UserSignupModel
    ): Call<String>

    @Headers("Content-Type:application/json")
    @POST("/register/user_details_after_signup")
    fun postAfterSignUp(
        @Query("api_key") api_key: String,
        @Query("email") email: String,
        @Query("sex_string") sex_string: String,
        @Query("address") address: String,
        @Query("blood") blood_group: Date,
        @Query("weight") weight: Float,
        @Query("height") height: Float,
    ): Call<List<String>>
}