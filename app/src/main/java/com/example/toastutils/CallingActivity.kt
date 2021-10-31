package com.example.toastutils

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.toaster.model.ResponseLogin
import com.example.toaster.view.ToastMainActivity
import com.example.toaster.view.ToasterUtils
import com.example.toastutils.databinding.ActivityMainBinding

class CallingActivity : ToastMainActivity() , ToastMainActivity.ToastCallBack{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_calling)

        init(this)
        //changeTextViewColor(R.color.purple_700)
    }

    override fun getResponseData(responseLogin: ResponseLogin){
        ToasterUtils.showRedToast(this, responseLogin.data.firstName+": toast from client app")
    }
}