package com.example.toaster.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.example.toaster.R
import com.example.toaster.manager.ApiManager
import com.example.toaster.model.ResponseLogin
import com.example.toaster.network.NetworkManagerClient
import com.example.toaster.viewmodel.SigninViewModel

class ToastView : FrameLayout, UpdateUI {
    private lateinit var button_first : Button
    private lateinit var progress : ProgressBar
    lateinit var signInViewModel: SigninViewModel
    lateinit var tv_1: TextView
    lateinit var tv_2: TextView
    lateinit var tv_3: TextView
    lateinit var tv_4: TextView
    lateinit var mContext: Context

    constructor(context: Context) : super(context) {
        initViews(context)
    }

    constructor(context: Context, attrs: AttributeSet) :
            super(context, attrs) {
        initViews(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr) {
        initViews(context)
    }

    fun initViews(context: Context) {
        NetworkManagerClient.getInstance().init(context, "https://reqres.in/", "",
            "", ", ", "", "")
        this.mContext = context;
        inflate(context, R.layout.activity_toast, this)

        button_first = findViewById(R.id.button_first)
        progress = findViewById(R.id.progress_circular)
        tv_1 = findViewById(R.id.tv_0)
        tv_2 = findViewById(R.id.tv_1)
        tv_3 = findViewById(R.id.tv_2)
        tv_4 = findViewById(R.id.tv_3)
        button_first.setOnClickListener {
            ToasterUtils.showRedToast(context, "Sdk button clicked")
        }
        //signInViewModel = ViewModelProvider()[SigninViewModel::class.java]
        //registerObs(context)
        //signInViewModel.performLogin()

        ApiManager.callSinInApiRx(this)
    }

    override fun changeTextColor(color: Int){
        button_first.setTextColor(color)
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }

    override fun  onSuccess(responseLogin: ResponseLogin) {
        progress.visibility = View.GONE
        if(responseLogin!= null){
            tv_1.text = responseLogin.data.email
            tv_2.text = responseLogin.data.firstName
            tv_3.text = responseLogin.data.lastName
            tv_4.text = responseLogin.support.text
        } else {
            ToasterUtils.showRedToast(mContext, "Something went wrong")
        }
    }


    private fun setViewModel() {

    }

}

interface UpdateUI{
    fun changeTextColor(color: Int){

    }
    fun showProgress()
    fun hideProgress()
    fun onSuccess(responseLogin: ResponseLogin)
}