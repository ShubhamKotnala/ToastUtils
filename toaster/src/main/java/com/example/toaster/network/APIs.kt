package com.example.toaster.network

import androidx.annotation.Keep
import com.example.toaster.model.RequestLogin
import com.example.toaster.model.ResponseLogin
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * All API's should go here
 */
@Keep
interface APIs {
    //www.google.com/maps
    @POST("users/2")
    fun login(): Call<ResponseLogin>

}
