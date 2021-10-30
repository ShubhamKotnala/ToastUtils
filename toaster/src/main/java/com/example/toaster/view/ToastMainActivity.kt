package com.example.toaster.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.toaster.R
import com.example.toaster.model.ResponseLogin
import com.example.toaster.network.NetworkManagerClient
import com.example.toaster.viewmodel.SigninViewModel

open class ToastMainActivity : AppCompatActivity() {

    lateinit var signInViewModel: SigninViewModel
    lateinit var tv_1: TextView
    lateinit var tv_2: TextView
    lateinit var tv_3: TextView
    lateinit var tv_4: TextView
    lateinit var button_first: Button
    lateinit var progress_circular: ProgressBar
    lateinit var toastCallBack: ToastCallBack

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)

        NetworkManagerClient.getInstance().init(this, "https://reqres.in/", "",
            "", ", ", "", "")
        tv_1 = findViewById(R.id.tv_0)
        tv_2 = findViewById(R.id.tv_1)
        tv_3 = findViewById(R.id.tv_2)
        tv_4 = findViewById(R.id.tv_3)
        button_first = findViewById(R.id.button_first)
        progress_circular = findViewById(R.id.progress_circular)

        signInViewModel = ViewModelProvider(this)[SigninViewModel::class.java]
        registerObs()
        progress_circular.visibility = View.VISIBLE
        signInViewModel.performLogin()

        button_first.setOnClickListener {
            ToasterUtils.showRedToast(this, "Sdk button clicked")
        }
    }

    public fun init(toastCallBack: ToastCallBack) {
        this.toastCallBack = toastCallBack
    }

    private fun registerObs(){
        signInViewModel.liveAction.observe(this, Observer { liveAction: ResponseLogin? ->
            progress_circular.visibility = View.GONE
            if(liveAction!= null){
                tv_1.text = liveAction.data.email
                tv_2.text = liveAction.data.firstName
                tv_3.text = liveAction.data.lastName
                tv_4.text = liveAction.support.text
                toastCallBack.getResponseData(liveAction)
            } else
            {
                ToasterUtils.showRedToast(this, "Something went wrong")
            }

        })
    }

    public fun changeTextView(string: String){
        tv_1.text = "text has been updated"
    }

    public fun recallApi(){
        signInViewModel.performLogin()
    }

    interface ToastCallBack {
        fun getResponseData(responseLogin: ResponseLogin)
    }
}