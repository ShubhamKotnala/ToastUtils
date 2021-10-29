package com.example.toaster.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.toaster.R
import com.example.toaster.model.ResponseLogin
import com.example.toaster.network.NetworkManagerClient
import com.example.toaster.viewmodel.SigninViewModel

open class ToastMainActivity : AppCompatActivity() {

    lateinit var signInViewModel: SigninViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)

        NetworkManagerClient.getInstance().init(this, "https://reqres.in/", "",
            "", ", ", "", "")
        signInViewModel = ViewModelProvider(this)[SigninViewModel::class.java]
    }

    override fun onResume() {
        super.onResume()

        signInViewModel.performLogin()
    }

    private fun registerObs(){
        signInViewModel.liveAction.observe(this, Observer { liveAction: ResponseLogin? ->


        })
    }
}