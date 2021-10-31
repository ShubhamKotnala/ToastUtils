package com.example.toaster.network

import androidx.annotation.Keep
import com.example.toaster.model.RequestLogin
import com.example.toaster.model.ResponseLogin
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * All API's should go here
 */
@Keep
interface APIs {
    //www.google.com/maps
    @GET("api/users/2")
    fun login(): Call<ResponseLogin>

    @GET("api/users/2")
    fun loginusingRx(): Observable<ResponseLogin>

}
