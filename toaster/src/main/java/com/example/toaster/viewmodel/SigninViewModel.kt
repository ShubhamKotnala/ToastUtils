package com.example.toaster.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.toaster.model.RequestLogin
import com.example.toaster.model.ResponseLogin
import com.example.toaster.network.APIs
import com.example.toaster.network.NetworkManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SigninViewModel : ViewModel() {

    val liveAction = MutableLiveData<ResponseLogin?>()

    fun performLogin() {
        val apiInterface = NetworkManager.getApiClient().login()
        //apiInterface.enqueue( Callback<List<Movie>>())
        apiInterface.enqueue( object : Callback<ResponseLogin> {
            override fun onFailure(call: Call<ResponseLogin>, t: Throwable?) {

            }

            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                if(response != null)
                   liveAction.postValue(response.body())
            }
        })
        }
    }

    private fun onLoginRequest(requestLogin: RequestLogin) {


}